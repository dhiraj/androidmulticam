package com.dhirajgupta.multicam

import android.app.Application
import android.media.MediaScannerConnection
import timber.log.Timber

/**
 * Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object,
 * we are able to access the Application Context anywhere that it is useful. In this particular project we're using
 * Application Context to ask [MediaScannerConnection] to scan our newly saved images so that it appears in the user's
 * Photo Gallery application.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) { //Debug level logging so that we can see logging output in LogCat console
            Timber.plant(Timber.DebugTree())
        }
        Timber.i("App starting up...")
    }
    companion object {
        lateinit var instance: App
            private set
    }
}