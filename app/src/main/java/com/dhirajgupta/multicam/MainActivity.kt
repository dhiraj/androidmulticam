package com.dhirajgupta.multicam

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.dhirajgupta.multicam.interfaces.CAMERASTATE_IDLE
import com.dhirajgupta.multicam.interfaces.ManagedCameraStatus
import com.dhirajgupta.multicam.services.ManagedCamera
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {
    ////////////////////////////////// Instance Vars //////////////////////////////////////////////

    var camera0: ManagedCamera? = null
    var camera1: ManagedCamera? = null

    ////////////////////////////////// Activity Constants //////////////////////////////////////////

    /**
     * Request code for Camera permission request
     */
    val PERMREQ_CAMERA = 101

    ////////////////////////////////// Activity Methods //////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val asked = askAllRequiredPermissions()
        if (!asked){
            allPermissionsGranted()
        }
    }

    /**
     * Even though we're not using Fragments, *right now*, we will ultimately do so in the future,
     * so it makes sense to override onResumeFragments instead of onResume
     * We will perform on-foreground steps in this method, and open the camera(s) that were operating
     * in last session, or if [MainActivity] was just created, then the first Camera only
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
        Timber.i("onResumeFragments")
        camera0?.prepareToPreview()
        camera1?.prepareToPreview()
    }

    /**
     * We must save the state of the app, including which cameras were operational and then,
     * relinquish control on the camera(s) so that the OS can allocate them as required
     */
    override fun onPause() {
        super.onPause()
        Timber.i("onPause Activity")
        camera0?.releaseResources()
        camera1?.releaseResources()
    }

    /**
     * Simple function that sets the [ManagedCamera.isPreviewing] to the opposite of whatever it is, currently, and
     * then asks the camera to update it's preview status.
     * As the status of the camera changes, the appropriate callbacks will be called to update [MainActivity] labels.
     */
    fun toggleCamera(view: Button, camera: ManagedCamera?) {
        camera?.let {
            it.isPreviewing = !it.isPreviewing
            it.updatePreviewStatus()
        }
    }


    /**
     * Handle Activity permission request responses
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMREQ_CAMERA) {
            //Camera and Storage permission code was requested, if not granted, then we finish the activity and quit the app
            // if the user wants to give permission, they will open the app again
            //ToDo: Show specific messages to user saying that they need to grant the particular permission
            val camera_permission_status = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
            val externalstorage_permission_status = ContextCompat.checkSelfPermission(this@MainActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (camera_permission_status != PackageManager.PERMISSION_GRANTED || externalstorage_permission_status != PackageManager.PERMISSION_GRANTED) {
                finish() // App will be restarted by the user
                return
            }
            allPermissionsGranted()
        }
    }

    //////////////////////////////////// Implementation and Utility methods ////////////////////////////////////////////////


    /**
     * Utility function to ask for any of our required permission
     * If the function did not ask for any permission, because all of them are granted already, returns false
     * else it asks for the required permissions and returns true
     */
    fun askAllRequiredPermissions(): Boolean {
        val camera_permission_status = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
        val externalstorage_permission_status = ContextCompat.checkSelfPermission(this@MainActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (camera_permission_status != PackageManager.PERMISSION_GRANTED || externalstorage_permission_status != PackageManager.PERMISSION_GRANTED) {
            Timber.i("Required permission NOT granted")
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) || shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Timber.i("Should show rationale")
                AlertDialog.Builder(this@MainActivity)
                    .setMessage(getString(R.string.camera_permission_rational_message))
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        // Ask permission again
                        requestPermissions(arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMREQ_CAMERA)
                    }
                    .setNegativeButton(getString(R.string.no)) { _, _ ->
                        finish() // User chose No, so we quit the activity (and exit the app)
                    }
                    .create()
                    .show()
            } else {
                // Ask permission for the first time
                Timber.i("Requesting camera permission...")
                requestPermissions(arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMREQ_CAMERA)
            }
            return true
        }
        return false
    }

    /**
     * Implementation of Custom interface to handle communication from [ManagedCamera] back to [MainActivity].
     */
    val cameraStatusHandler = object : ManagedCameraStatus {
        override fun cameraFPSchanged(
            camera: ManagedCamera,
            fps: Int
        ) {
//            Timber.i("Cam ${camera.systemId} FPS changed: $fps")
            if (camera.cameraState == CAMERASTATE_IDLE) {
                Timber.w("Ignoring FPS change because Cam ${camera.systemId} is IDLE!!")
                return
            }
            if (camera.systemId == camera0?.systemId) {
                textview_cam0_description.text = getString(R.string.camera_description).format(camera.systemId, fps)
            } else {
                textview_cam1_description.text = getString(R.string.camera_description).format(camera.systemId, fps)
            }
        }

        override fun cameraStateChanged(
            camera: ManagedCamera,
            state: Int
        ) {
            Timber.i("Cam ${camera.systemId}  State changed: $state")
            if (state != CAMERASTATE_IDLE) {
                if (camera.systemId == camera0?.systemId) {
                    //Camera 0 is previewing
                    button_toggle_cam_0.text = "${getString(R.string.stop)} ${camera.systemId}"
                } else {
                    //Camera 1 is previewing
                    button_toggle_cam_1.text = "${getString(R.string.stop)} ${camera.systemId}"
                }
            } else {
                if (camera.systemId == camera0?.systemId) {
                    //Camera 0 is idle
                    button_toggle_cam_0.text = "${getString(R.string.start)} ${camera.systemId}"
                    textview_cam0_description.text = getString(R.string.camera_description_idle).format(camera.systemId)
                } else {
                    //Camera 1 is idle
                    button_toggle_cam_1.text = "${getString(R.string.start)} ${camera.systemId}"
                    textview_cam1_description.text = getString(R.string.camera_description_idle).format(camera.systemId)
                }
            }
        }

        override fun cameraSavedPhoto(camera: ManagedCamera, filePath: File) {
            AlertDialog.Builder(this@MainActivity)
                .setMessage(getString(R.string.camera_saved_photo).format(camera.systemId,filePath.absolutePath))
                .setNeutralButton(getString(R.string.ok), null)
                .create()
                .show()
        }
    }

    /**
     * Checks available cameras and inits them. At least one camera is required, else the app will quit
     */
    fun initCameras() {
        val manager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        Timber.i("Available cameras: %s", Arrays.toString(manager.cameraIdList))
        if (manager.cameraIdList.size < 1) {
            AlertDialog.Builder(this@MainActivity)
                .setMessage(getString(R.string.this_device_has_no_cameras))
                .setNeutralButton(getString(R.string.ok)) { _, _ ->
                    finish() //Finish the activity because there are no cameras
                }
                .create()
                .show()
        }
        camera0 = ManagedCamera(
            manager.cameraIdList[0],
            "Camera${manager.cameraIdList[0]}}",
            view_finder_0,
            cameraStatusHandler
        )
        if (manager.cameraIdList.size >= 2) {
            camera1 = ManagedCamera(
                manager.cameraIdList[1],
                "Camera${manager.cameraIdList[1]}}",
                view_finder_1,
                cameraStatusHandler
            )
        }
    }

    /**
     * All the required permissions have been granted, so we can now do the sensitive operations that require these
     * permissions, namely initing the cameras and also creating the storage folder that will house saved images
     */
    fun allPermissionsGranted(){
        //Pre-create the folder chain that will allow us to save an album into External Storage
        val saveLocation = File(Environment.getExternalStorageDirectory(),"MultiCam")
        val success = saveLocation.mkdirs()
        Timber.i("Created folder:$success at $saveLocation")

        initCameras()
        camera0?.isPreviewing = true // Default to showing the first camera, it will automatically start when ready
        button_toggle_cam_0.setOnClickListener { toggleCamera(button_toggle_cam_0, camera0) }
        button_toggle_cam_1.setOnClickListener { toggleCamera(button_toggle_cam_1, camera1) }
        button_save.setOnClickListener {
            Timber.i("Save button pressed")
            camera0?.let {
                if (it.cameraState == CAMERASTATE_IDLE){
                    Timber.i("Ignoring Camera 0 because it is idle!")
                    return@let
                }
                it.lockFocus() //Actually triggers saving an image from the camera
            }
            camera1?.let {
                if (it.cameraState == CAMERASTATE_IDLE){
                    Timber.i("Ignoring Camera 0 because it is idle!")
                    return@let
                }
                it.lockFocus() //Actually triggers saving an image from the camera
            }
        }
    }

}