[app](../../index.md) / [com.dhirajgupta.multicam](../index.md) / [MainActivity](index.md) / [toggleCamera](./toggle-camera.md)

# toggleCamera

`fun toggleCamera(camera: `[`ManagedCamera`](../../com.dhirajgupta.multicam.services/-managed-camera/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Simple function that sets the [ManagedCamera.isPreviewing](../../com.dhirajgupta.multicam.services/-managed-camera/is-previewing.md) to the opposite of whatever it is, currently, and
then asks the camera to update it's preview status.
As the status of the camera changes, the appropriate callbacks will be called to update [MainActivity](index.md) labels.

