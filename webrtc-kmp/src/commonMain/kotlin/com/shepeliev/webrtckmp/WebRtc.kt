package com.shepeliev.webrtckmp

@Deprecated("It will be removed in one of the future releases.")
expect object WebRtc {

    @Deprecated(
        message = "Use MediaDevices companion object.",
        replaceWith = ReplaceWith("MediaDevices")
    )
    val mediaDevices: MediaDevices
}