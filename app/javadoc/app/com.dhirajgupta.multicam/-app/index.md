[app](../../index.md) / [com.dhirajgupta.multicam](../index.md) / [App](./index.md)

# App

`class App : `[`Application`](https://developer.android.com/reference/android/app/Application.html)

Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object,
we are able to access the Application Context anywhere that it is useful. In this particular project we're using
Application Context to ask [MediaScannerConnection](https://developer.android.com/reference/android/media/MediaScannerConnection.html) to scan our newly saved images so that it appears in the user's
Photo Gallery application.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `App()`<br>Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object, we are able to access the Application Context anywhere that it is useful. In this particular project we're using Application Context to ask [MediaScannerConnection](https://developer.android.com/reference/android/media/MediaScannerConnection.html) to scan our newly saved images so that it appears in the user's Photo Gallery application. |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [instance](instance.md) | `lateinit var instance: `[`App`](./index.md) |
