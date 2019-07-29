

### All Types

| Name | Summary |
|---|---|
| [com.dhirajgupta.multicam.App](../com.dhirajgupta.multicam/-app/index.md) | Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object, we are able to access the Application Context anywhere that it is useful. In this particular project we're using Application Context to ask [MediaScannerConnection](https://developer.android.com/reference/android/media/MediaScannerConnection.html) to scan our newly saved images so that it appears in the user's Photo Gallery application. |
| [com.dhirajgupta.multicam.views.AutoFitTextureView](../com.dhirajgupta.multicam.views/-auto-fit-texture-view/index.md) | A [TextureView](https://developer.android.com/reference/android/view/TextureView.html) that can be adjusted to a specified aspect ratio. |
| [com.dhirajgupta.multicam.utils.CompareSizesByArea](../com.dhirajgupta.multicam.utils/-compare-sizes-by-area/index.md) | Compares two `Size`s based on their areas. |
| [com.dhirajgupta.multicam.MainActivity](../com.dhirajgupta.multicam/-main-activity/index.md) |  |
| [com.dhirajgupta.multicam.services.ManagedCamera](../com.dhirajgupta.multicam.services/-managed-camera/index.md) | This class is heavily inspired from Google's Camera2Basic sample at https://github.com/googlesamples/android-Camera2Basic Heavy refactoring has been carried out to move all the code from the Fragment in the sample to a self contained [ManagedCamera](../com.dhirajgupta.multicam.services/-managed-camera/index.md) class that can take care of it's own threads and is almost fully self sufficient. By modularizing the Camera in this way we are able to easily create multiple instances (two in this case) while the implementation code remains common between both the cameras. |
| [com.dhirajgupta.multicam.interfaces.ManagedCameraStatus](../com.dhirajgupta.multicam.interfaces/-managed-camera-status/index.md) | Consumers of [ManagedCamera](../com.dhirajgupta.multicam.services/-managed-camera/index.md) need to supply an implementation of this interface to allow the camera instance to communicate back as required |
