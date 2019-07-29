package com.dhirajgupta.multicam.interfaces

import com.dhirajgupta.multicam.services.ManagedCamera
import java.io.File

/**
 * Camera state: Idle / Not started.
 */
val CAMERASTATE_IDLE = -1

/**
 * Camera state: Showing camera preview.
 */
val CAMERASTATE_PREVIEW = 0

/**
 * Camera state: Waiting for the focus to be locked.
 */
val CAMERASTATE_WAITING_LOCK = 1

/**
 * Camera state: Waiting for the exposure to be precapture state.
 */
val CAMERASTATE_WAITING_PRECAPTURE = 2

/**
 * Camera state: Waiting for the exposure state to be something other than precapture.
 */
val CAMERASTATE_WAITING_NON_PRECAPTURE = 3

/**
 * Camera state: Picture was taken.
 */
val CAMERASTATE_PICTURE_TAKEN = 4

/**
 * Consumers of [ManagedCamera] need to supply an implementation of this interface to allow the camera instance to
 * communicate back as required
 */
interface ManagedCameraStatus {
    fun cameraFPSchanged(camera: ManagedCamera, fps: Int)
    fun cameraStateChanged(camera: ManagedCamera, state: Int)
    fun cameraSavedPhoto(camera: ManagedCamera, filePath:File)
}