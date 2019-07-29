[app](../index.md) / [com.dhirajgupta.multicam.interfaces](./index.md)

## Package com.dhirajgupta.multicam.interfaces

### Types

| Name | Summary |
|---|---|
| [ManagedCameraStatus](-managed-camera-status/index.md) | `interface ManagedCameraStatus`<br>Consumers of [ManagedCamera](../com.dhirajgupta.multicam.services/-managed-camera/index.md) need to supply an implementation of this interface to allow the camera instance to communicate back as required |

### Properties

| Name | Summary |
|---|---|
| [CAMERASTATE_IDLE](-c-a-m-e-r-a-s-t-a-t-e_-i-d-l-e.md) | `val CAMERASTATE_IDLE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Idle / Not started. |
| [CAMERASTATE_PICTURE_TAKEN](-c-a-m-e-r-a-s-t-a-t-e_-p-i-c-t-u-r-e_-t-a-k-e-n.md) | `val CAMERASTATE_PICTURE_TAKEN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Picture was taken. |
| [CAMERASTATE_PREVIEW](-c-a-m-e-r-a-s-t-a-t-e_-p-r-e-v-i-e-w.md) | `val CAMERASTATE_PREVIEW: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Showing camera preview. |
| [CAMERASTATE_WAITING_LOCK](-c-a-m-e-r-a-s-t-a-t-e_-w-a-i-t-i-n-g_-l-o-c-k.md) | `val CAMERASTATE_WAITING_LOCK: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Waiting for the focus to be locked. |
| [CAMERASTATE_WAITING_NON_PRECAPTURE](-c-a-m-e-r-a-s-t-a-t-e_-w-a-i-t-i-n-g_-n-o-n_-p-r-e-c-a-p-t-u-r-e.md) | `val CAMERASTATE_WAITING_NON_PRECAPTURE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Waiting for the exposure state to be something other than precapture. |
| [CAMERASTATE_WAITING_PRECAPTURE](-c-a-m-e-r-a-s-t-a-t-e_-w-a-i-t-i-n-g_-p-r-e-c-a-p-t-u-r-e.md) | `val CAMERASTATE_WAITING_PRECAPTURE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Camera state: Waiting for the exposure to be precapture state. |
