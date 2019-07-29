[app](../../index.md) / [com.dhirajgupta.multicam](../index.md) / [App](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`App()`

Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object,
we are able to access the Application Context anywhere that it is useful. In this particular project we're using
Application Context to ask [MediaScannerConnection](https://developer.android.com/reference/android/media/MediaScannerConnection.html) to scan our newly saved images so that it appears in the user's
Photo Gallery application.

