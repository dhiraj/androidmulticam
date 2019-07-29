[app](../index.md) / [com.dhirajgupta.multicam.services](./index.md)

## Package com.dhirajgupta.multicam.services

### Types

| Name | Summary |
|---|---|
| [ManagedCamera](-managed-camera/index.md) | `class ManagedCamera`<br>This class is heavily inspired from Google's Camera2Basic sample at https://github.com/googlesamples/android-Camera2Basic Heavy refactoring has been carried out to move all the code from the Fragment in the sample to a self contained [ManagedCamera](-managed-camera/index.md) class that can take care of it's own threads and is almost fully self sufficient. By modularizing the Camera in this way we are able to easily create multiple instances (two in this case) while the implementation code remains common between both the cameras. |
