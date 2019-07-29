[app](../../index.md) / [com.dhirajgupta.multicam.services](../index.md) / [ManagedCamera](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ManagedCamera(systemId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, threadName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, textureView: `[`AutoFitTextureView`](../../com.dhirajgupta.multicam.views/-auto-fit-texture-view/index.md)`, listener: `[`ManagedCameraStatus`](../../com.dhirajgupta.multicam.interfaces/-managed-camera-status/index.md)`)`

This class is heavily inspired from Google's Camera2Basic sample at https://github.com/googlesamples/android-Camera2Basic
Heavy refactoring has been carried out to move all the code from the Fragment in the sample to a self contained
[ManagedCamera](index.md) class that can take care of it's own threads and is almost fully self sufficient.
By modularizing the Camera in this way we are able to easily create multiple instances (two in this case) while the
implementation code remains common between both the cameras.

