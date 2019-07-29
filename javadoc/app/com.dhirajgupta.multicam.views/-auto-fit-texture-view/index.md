[app](../../index.md) / [com.dhirajgupta.multicam.views](../index.md) / [AutoFitTextureView](./index.md)

# AutoFitTextureView

`class AutoFitTextureView : `[`TextureView`](https://developer.android.com/reference/android/view/TextureView.html)

A [TextureView](https://developer.android.com/reference/android/view/TextureView.html) that can be adjusted to a specified aspect ratio.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AutoFitTextureView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`? = null, defStyle: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`<br>A [TextureView](https://developer.android.com/reference/android/view/TextureView.html) that can be adjusted to a specified aspect ratio. |

### Functions

| Name | Summary |
|---|---|
| [onMeasure](on-measure.md) | `fun onMeasure(widthMeasureSpec: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, heightMeasureSpec: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setAspectRatio](set-aspect-ratio.md) | `fun setAspectRatio(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the aspect ratio for this view. The size of the view will be measured based on the ratio calculated from the parameters. Note that the actual sizes of parameters don't matter, that is, calling setAspectRatio(2, 3) and setAspectRatio(4, 6) make the same result. |
