package com.dhirajgupta.multicam.services

import android.media.Image
import android.media.MediaScannerConnection
import android.net.Uri
import com.dhirajgupta.multicam.App
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


/**
 * Saves a JPEG [Image] into the specified [File].
 */
internal class ImageSaver(
        /**
         * The JPEG image
         */
        private val image: Image,

        /**
         * The file we save the image into.
         */
        private val file: File
) : Runnable {

    override fun run() {
        val buffer = image.planes[0].buffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes)
        var output: FileOutputStream? = null
        try {
            output = FileOutputStream(file).apply {
                write(bytes)
            }
        } catch (e: IOException) {
            Timber.e(e)
        } finally {
            image.close()
            output?.let {
                try {
                    it.close()
                } catch (e: IOException) {
                    Timber.e(e)
                }
            }

            /**
             * Ask the MediaScanner service to scan the file that we just saved on to External Storage so that it
             * becomes available in the Device gallery
             */
            MediaScannerConnection.scanFile(
                App.instance,
                arrayOf(file.absolutePath),
                null,
                object : MediaScannerConnection.OnScanCompletedListener {
                    override fun onScanCompleted(path: String?, uri: Uri?) {
                        Timber.i("ContentScanner scanned path:$path, uri:$uri")
                    }
                })
        }
    }

}
