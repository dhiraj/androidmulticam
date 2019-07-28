package com.dhirajgupta.multicam.service

import android.graphics.SurfaceTexture
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.os.Handler
import android.os.HandlerThread
import android.view.Surface
import android.view.TextureView
import timber.log.Timber

class ManagedCamera(
    /**
     * systemId holds the cameraId that maps this camera instance to the system's camera device number.
     */
    var systemId: String,

    /**
     * Name of the thread that this camera object will use
     */
    var threadName: String
) {

    /**
     * An additional thread for running tasks that shouldn't block the UI.
     */
    private var backgroundThread: HandlerThread? = null

    /**
     * A [Handler] for running tasks in the background.
     */
    private var backgroundHandler: Handler? = null

    var device: CameraDevice? = null
    val textureListener = object : TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(p0: SurfaceTexture?, p1: Int, p2: Int) {
            Timber.i("onSurfaceTextureAvailable")
        }

        override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {
            Timber.i("onSurfaceTextureSizeChanged")
        }

        override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {
//            Timber.i("onSurfaceTextureUpdated")
        }

        override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
            Timber.i("onSurfaceTextureDestroyed")
            return true
        }
    }

    val captureSessionCallback = object : CameraCaptureSession.StateCallback() {
        override fun onReady(session: CameraCaptureSession) {
            super.onReady(session)
            Timber.i("OnReady")
        }

        override fun onCaptureQueueEmpty(session: CameraCaptureSession) {
            super.onCaptureQueueEmpty(session)
            Timber.i("onCaptureQueueEmpty")
        }

        override fun onConfigureFailed(p0: CameraCaptureSession) {
            Timber.i("onConfigureFailed")
        }

        override fun onClosed(session: CameraCaptureSession) {
            super.onClosed(session)
            Timber.i("onClosed")
        }

        override fun onSurfacePrepared(session: CameraCaptureSession, surface: Surface) {
            super.onSurfacePrepared(session, surface)
            Timber.i("onSurfacePrepared")
        }

        override fun onConfigured(p0: CameraCaptureSession) {
            Timber.i("onConfigured")
        }

        override fun onActive(session: CameraCaptureSession) {
            super.onActive(session)
            Timber.i("onActive")
        }
    }

    val cameraStateCallback = object : CameraDevice.StateCallback() {
        override fun onOpened(camera: CameraDevice) {
            Timber.i("Opened")
        }

        override fun onClosed(camera: CameraDevice) {
            super.onClosed(camera)
            Timber.i("Closed")
        }

        override fun onDisconnected(camera: CameraDevice) {
            Timber.i("Disconnected")
        }

        override fun onError(camera: CameraDevice, errorCode: Int) {
            Timber.i("Error: %d", errorCode)
        }
    }

    fun startPreview() {

    }

    fun stopPreview() {

    }

    fun prepareToPreview() {
        backgroundThread = HandlerThread(threadName).also { it.start() }
        backgroundHandler = Handler(backgroundThread?.looper)
        Timber.i("Started background thread: ${threadName}")
    }

    fun releaseResources() {
        backgroundThread?.quitSafely()
        try {
            backgroundThread?.join()
            backgroundThread = null
            backgroundHandler = null
            Timber.i("Released background thread: ${threadName}")
        } catch (e: InterruptedException) {
            Timber.e(e)
        }

    }
}