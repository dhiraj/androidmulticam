[app](../../index.md) / [com.dhirajgupta.multicam.services](../index.md) / [ManagedCamera](./index.md)

# ManagedCamera

`class ManagedCamera`

This class is heavily inspired from Google's Camera2Basic sample at https://github.com/googlesamples/android-Camera2Basic
Heavy refactoring has been carried out to move all the code from the Fragment in the sample to a self contained
[ManagedCamera](./index.md) class that can take care of it's own threads and is almost fully self sufficient.
By modularizing the Camera in this way we are able to easily create multiple instances (two in this case) while the
implementation code remains common between both the cameras.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ManagedCamera(systemId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, threadName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, textureView: `[`AutoFitTextureView`](../../com.dhirajgupta.multicam.views/-auto-fit-texture-view/index.md)`, listener: `[`ManagedCameraStatus`](../../com.dhirajgupta.multicam.interfaces/-managed-camera-status/index.md)`)`<br>This class is heavily inspired from Google's Camera2Basic sample at https://github.com/googlesamples/android-Camera2Basic Heavy refactoring has been carried out to move all the code from the Fragment in the sample to a self contained [ManagedCamera](./index.md) class that can take care of it's own threads and is almost fully self sufficient. By modularizing the Camera in this way we are able to easily create multiple instances (two in this case) while the implementation code remains common between both the cameras. |

### Properties

| Name | Summary |
|---|---|
| [activity](activity.md) | `val activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html) |
| [cameraState](camera-state.md) | `var cameraState: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The current state of camera state for taking pictures. REFACTORING NOTE: CAMERASTSATE_IDLE has been specifically added to allow consumers to know when the Camera is idle |
| [isPreviewing](is-previewing.md) | `var isPreviewing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A flag to match the preview playing status of the camera. If initially set to true, then the [ManagedCamera](./index.md) instance will automatically start the preview when it becomes possible |
| [lastFPS](last-f-p-s.md) | `var lastFPS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Capture the last FPS to allow debouncing to notify the consumer only when an FPS change is actually detected. |
| [lastMillis](last-millis.md) | `var lastMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Capture the last milliseconds to allow fps calculation for this camera view |
| [listener](listener.md) | `val listener: `[`ManagedCameraStatus`](../../com.dhirajgupta.multicam.interfaces/-managed-camera-status/index.md)<br>Listener to observe notifications from camera state and FPS changeΩs |
| [surfaceTextureListener](surface-texture-listener.md) | `val surfaceTextureListener: `[`SurfaceTextureListener`](https://developer.android.com/reference/android/view/TextureView/SurfaceTextureListener.html) |
| [systemId](system-id.md) | `val systemId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>systemId holds the cameraId that maps this camera instance to the system's camera device number. |
| [textureView](texture-view.md) | `val textureView: `[`AutoFitTextureView`](../../com.dhirajgupta.multicam.views/-auto-fit-texture-view/index.md)<br>An [AutoFitTextureView](../../com.dhirajgupta.multicam.views/-auto-fit-texture-view/index.md) for camera preview. |
| [threadName](thread-name.md) | `val threadName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the thread that this camera object will use |

### Functions

| Name | Summary |
|---|---|
| [lockFocus](lock-focus.md) | `fun lockFocus(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Lock the focus as the first step for a still image capture. |
| [prepareToPreview](prepare-to-preview.md) | `fun prepareToPreview(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The Consumer should call this method when it wants the [ManagedCamera](./index.md) to become ready to function If [isPreviewing](is-previewing.md) is set to true before calling this function, then the camera instance will automatically start the Camera preview in the supplied TextureView as well |
| [releaseResources](release-resources.md) | `fun releaseResources(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The Consumer should call this method when it wants the [ManagedCamera](./index.md) to release camera resources, and shut down any ongoing previews. |
| [updatePreviewStatus](update-preview-status.md) | `fun updatePreviewStatus(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Is called whenever the implementation should be made to match up with the state of [isPreviewing](is-previewing.md). [cameraState](camera-state.md) is also set to IDLE or PREVIEW to match with the implementation, here. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [filenameFormat](filename-format.md) | `val filenameFormat: `[`SimpleDateFormat`](https://developer.android.com/reference/java/text/SimpleDateFormat.html) |
