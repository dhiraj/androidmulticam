[app](../../index.md) / [com.dhirajgupta.multicam](../index.md) / [MainActivity](index.md) / [onResumeFragments](./on-resume-fragments.md)

# onResumeFragments

`protected fun onResumeFragments(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Even though we're not using Fragments, *right now*, we will ultimately do so in the future,
so it makes sense to override onResumeFragments instead of onResume
We will perform on-foreground steps in this method, and open the camera(s) that were operating
in last session, or if [MainActivity](index.md) was just created, then the first Camera only

