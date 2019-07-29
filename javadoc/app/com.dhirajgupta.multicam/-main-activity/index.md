[app](../../index.md) / [com.dhirajgupta.multicam](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()` |

### Properties

| Name | Summary |
|---|---|
| [camera0](camera0.md) | `var camera0: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`?` |
| [camera1](camera1.md) | `var camera1: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`?` |
| [cameraStatusHandler](camera-status-handler.md) | `val cameraStatusHandler: `[`ManagedCameraStatus`](../../com.dhirajgupta.multicam.interfaces/-managed-camera-status/index.md)<br>Implementation of Custom interface to handle communication from [ManagedCamera](../../com.dhirajgupta.multicam.services/-managed-camera/index.md) back to [MainActivity](./index.md). |
| [PERMREQ_CAMERA](-p-e-r-m-r-e-q_-c-a-m-e-r-a.md) | `val PERMREQ_CAMERA: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Request code for Camera permission request |

### Functions

| Name | Summary |
|---|---|
| [allPermissionsGranted](all-permissions-granted.md) | `fun allPermissionsGranted(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>All the required permissions have been granted, so we can now do the sensitive operations that require these permissions, namely initing the cameras and also creating the storage folder that will house saved images |
| [askAllRequiredPermissions](ask-all-required-permissions.md) | `fun askAllRequiredPermissions(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Utility function to ask for any of our required permission If the function did not ask for any permission, because all of them are granted already, returns false else it asks for the required permissions and returns true |
| [initCameras](init-cameras.md) | `fun initCameras(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Checks available cameras and inits them. At least one camera is required, else the app will quit |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onPause](on-pause.md) | `fun onPause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>We must save the state of the app, including which cameras were operational and then, relinquish control on the camera(s) so that the OS can allocate them as required |
| [onRequestPermissionsResult](on-request-permissions-result.md) | `fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handle Activity permission request responses |
| [onResumeFragments](on-resume-fragments.md) | `fun onResumeFragments(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Even though we're not using Fragments, *right now*, we will ultimately do so in the future, so it makes sense to override onResumeFragments instead of onResume We will perform on-foreground steps in this method, and open the camera(s) that were operating in last session, or if [MainActivity](./index.md) was just created, then the first Camera only |
| [toggleCamera](toggle-camera.md) | `fun toggleCamera(camera: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Simple function that sets the [ManagedCamera.isPreviewing](../../com.dhirajgupta.multicam.services/-managed-camera/is-previewing.md) to the opposite of whatever it is, currently, and then asks the camera to update it's preview status. As the status of the camera changes, the appropriate callbacks will be called to update [MainActivity](./index.md) labels. |
