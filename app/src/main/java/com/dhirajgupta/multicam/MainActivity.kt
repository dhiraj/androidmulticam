package com.dhirajgupta.multicam

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    ////////////////////////////////// Instance Vars //////////////////////////////////////////////

    ////////////////////////////////// Activity Constants //////////////////////////////////////////

    /**
     * Request code for Camera permission request
     */
    val PERMREQ_CAMERA = 101

    ////////////////////////////////// Activity Methods //////////////////////////////////////////
    /**
     * Set up the activity with all one-time activity init related steps
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Even though we're not using Fragments, *right now*, we will ultimately do so in the future,
     * so it makes sense to override onResumeFragments instead of onResume
     * We will perform on-foreground steps in this method, and open the camera(s) that were operating
     * at last run
     */
    override fun onResumeFragments() {
        super.onResumeFragments()
        Timber.i("onResumeFragments")
        askCameraPermission()
    }

    /**
     * We must save the state of the app, including which cameras were operational and then,
     * relinquish control on the camera(s) so that the OS can allocate them as required
     */
    override fun onPause() {
        super.onPause()
        Timber.i("onPause Activity")
    }

    /**
     * Handle Activity permission requests
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMREQ_CAMERA) {
            //Camera permission code was requested, if not granted, then we finish the activity and quit the app
            // if the user wants to give permission, they will open the app again
            if (grantResults.size != 1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Timber.i("User denied camera permission, finishing activity!")
                if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    // User has permanently denied Camera permission, so we prompt them to grant it from the Application
                    // Settings screen
                    AlertDialog.Builder(this@MainActivity)
                        .setMessage("Please grant Camera permission from App settings to allow this app to record video")
                        .setPositiveButton(getString(R.string.ok)) { _, _ ->
                            // Open app settings screen
                            startActivity(Intent().apply {
                                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                data = Uri.fromParts("package", packageName, null)
                            })
                            finish() // App will be restarted by the user after they give permission
                        }
                        .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                            finish() // User declined to open the application settings screen
                        }
                        .create()
                        .show()
                } else {
                    finish() // We're still allowed to show rationale for requesting permission (which will show the next
                    // time the user launches the app), so we quit silently
                }
            }
        }
    }

    //////////////////////////////////// Private ////////////////////////////////////////////////


    /**
     * Utility function to ask for Camera access permission, if required
     * If the function did not ask for permission, because it is granted already, returns false
     * else it asks for permission and returns true
     */
    fun askCameraPermission(): Boolean {
        val permission_status = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
        if (permission_status != PackageManager.PERMISSION_GRANTED) {
            Timber.i("Camera permission NOT granted")
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                Timber.i("Should show rationale")
                AlertDialog.Builder(this@MainActivity)
                    .setMessage("This app needs your permission to Record Video to function properly. Press No to exit, or Yes to proceed")
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        // Ask permission again
                        requestPermissions(arrayOf(Manifest.permission.CAMERA), PERMREQ_CAMERA)
                    }
                    .setNegativeButton(getString(R.string.no)) { _, _ ->
                        finish() // User chose No, so we quit the activity (and exit the app)
                    }
                    .create()
                    .show()
            } else {
                // Ask permission for the first time
                Timber.i("Requesting camera permission...")
                requestPermissions(arrayOf(Manifest.permission.CAMERA), PERMREQ_CAMERA)
            }
            return true
        }
        return false
    }

}