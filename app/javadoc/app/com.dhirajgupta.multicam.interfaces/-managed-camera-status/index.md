[app](../../index.md) / [com.dhirajgupta.multicam.interfaces](../index.md) / [ManagedCameraStatus](./index.md)

# ManagedCameraStatus

`interface ManagedCameraStatus`

Consumers of [ManagedCamera](../../com.dhirajgupta.multicam.services/-managed-camera/index.md) need to supply an implementation of this interface to allow the camera instance to
communicate back as required

### Functions

| Name | Summary |
|---|---|
| [cameraFPSchanged](camera-f-p-schanged.md) | `abstract fun cameraFPSchanged(camera: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`, fps: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cameraSavedPhoto](camera-saved-photo.md) | `abstract fun cameraSavedPhoto(camera: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`, filePath: `[`File`](https://developer.android.com/reference/java/io/File.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cameraStateChanged](camera-state-changed.md) | `abstract fun cameraStateChanged(camera: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`, state: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
