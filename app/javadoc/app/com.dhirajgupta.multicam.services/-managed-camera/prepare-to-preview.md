[app](../../index.md) / [com.dhirajgupta.multicam.services](../index.md) / [ManagedCamera](index.md) / [prepareToPreview](./prepare-to-preview.md)

# prepareToPreview

`fun prepareToPreview(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

The Consumer should call this method when it wants the [ManagedCamera](index.md) to become ready to function
If [isPreviewing](is-previewing.md) is set to true before calling this function, then the camera instance will automatically
start the Camera preview in the supplied TextureView as well

