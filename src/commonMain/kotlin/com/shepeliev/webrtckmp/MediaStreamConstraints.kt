package com.shepeliev.webrtckmp

data class MediaStreamConstraints(
    val audio: AudioTrackConstraints? = null,
    val video: VideoTrackConstraints? = null,
)

data class AudioTrackConstraints(
    val deviceId: String? = null,
    val groupId: String? = null,
    val autoGainControl: Constrain<Boolean>? = null,
    val channelCount: Constrain<Int>? = null,
    val echoCancellation: Constrain<Boolean>? = null,
    val latency: Constrain<Double>? = null,
    val noiseSuppression: Constrain<Boolean>? = null,
    val sampleRate: Constrain<Int>? = null,
    val volume: Constrain<Double>? = null,
)

data class VideoTrackConstraints(
    val deviceId: String? = null,
    val groupId: String? = null,
    val aspectRatio: Constrain<Double>? = null,
    val facingMode: Constrain<FacingMode>? = null,
    val frameRate: Constrain<Double>? = null,
    val height: Constrain<Int>? = null,
    val width: Constrain<Int>? = null,
    val resizeMode: Constrain<ResizeMode>? = null,
)

data class Size(val width: Int, val height: Int)

enum class FacingMode { User, Environment }

enum class ResizeMode { None, CropAndScale }

data class Constrain<T>(var exact: T? = null, var ideal: T? = null) {
    fun exact(value: T) {
        exact = value
    }

    fun ideal(value: T) {
        ideal = value
    }
}

class MediaStreamConstraintsBuilder {
    internal var constraints = MediaStreamConstraints()

    fun audio(enabled: Boolean = true) {
        if (enabled) {
            audio { }
        }
    }

    fun audio(build: AudioTrackConstraintsBuilder.() -> Unit) {
        val trackConstraintsBuilder = AudioTrackConstraintsBuilder(
            constraints.audio ?: AudioTrackConstraints()
        )
        build(trackConstraintsBuilder)
        constraints = constraints.copy(audio = trackConstraintsBuilder.constraints)
    }

    fun video(enabled: Boolean = true) {
        if (enabled) {
            video { }
        }
    }

    fun video(build: VideoTrackConstraintsBuilder.() -> Unit) {
        val trackConstraintsBuilder = VideoTrackConstraintsBuilder(
            constraints.video ?: VideoTrackConstraints()
        )
        build(trackConstraintsBuilder)
        constraints = constraints.copy(video = trackConstraintsBuilder.constraints)
    }
}

class AudioTrackConstraintsBuilder(internal var constraints: AudioTrackConstraints) {

    fun deviceId(id: String) {
        constraints = constraints.copy(deviceId = id)
    }

    fun groupId(id: String) {
        constraints = constraints.copy(groupId = id)
    }

    fun autoGainControl(enable: Boolean = true) {
        autoGainControl { exact(enable) }
    }

    fun autoGainControl(build: Constrain<Boolean>.() -> Unit) {
        val constrain = Constrain<Boolean>()
        build(constrain)
        constraints = constraints.copy(autoGainControl = constrain)
    }

    fun channelCount(count: Int) {
        channelCount { exact(count) }
    }

    fun channelCount(build: Constrain<Int>.() -> Unit) {
        val constrain = Constrain<Int>()
        build(constrain)
        constraints = constraints.copy(channelCount = constrain)
    }

    fun echoCancellation(enable: Boolean = true) {
        echoCancellation { exact(enable) }
    }

    fun echoCancellation(build: Constrain<Boolean>.() -> Unit) {
        val constrain = Constrain<Boolean>()
        build(constrain)
        constraints = constraints.copy(echoCancellation = constrain)
    }

    fun latency(latency: Double) {
        latency { exact(latency) }
    }

    fun latency(build: Constrain<Double>.() -> Unit) {
        val constrain = Constrain<Double>()
        build(constrain)
        constraints = constraints.copy(latency = constrain)
    }

    fun noiseSuppression(enable: Boolean = true) {
        noiseSuppression { exact(enable) }
    }

    fun noiseSuppression(build: Constrain<Boolean>.() -> Unit) {
        val constrain = Constrain<Boolean>()
        build(constrain)
        constraints = constraints.copy(noiseSuppression = constrain)
    }

    fun sampleRate(count: Int) {
        sampleRate { exact(count) }
    }

    fun sampleRate(build: Constrain<Int>.() -> Unit) {
        val constrain = Constrain<Int>()
        build(constrain)
        constraints = constraints.copy(sampleRate = constrain)
    }

    fun volume(volume: Double) {
        volume { exact(volume) }
    }

    fun volume(build: Constrain<Double>.() -> Unit) {
        val constrain = Constrain<Double>()
        build(constrain)
        constraints = constraints.copy(volume = constrain)
    }
}

class VideoTrackConstraintsBuilder(internal var constraints: VideoTrackConstraints) {

    fun deviceId(id: String) {
        constraints = constraints.copy(deviceId = id)
    }

    fun groupId(id: String) {
        constraints = constraints.copy(groupId = id)
    }

    fun aspectRatio(ratio: Double) {
        aspectRatio { exact(ratio) }
    }

    fun aspectRatio(build: Constrain<Double>.() -> Unit) {
        val constrain = Constrain<Double>()
        build(constrain)
        constraints = constraints.copy(aspectRatio = constrain)
    }

    fun facingMode(mode: FacingMode) {
        facingMode { exact(mode) }
    }

    fun facingMode(build: Constrain<FacingMode>.() -> Unit) {
        val constrain = Constrain<FacingMode>()
        build(constrain)
        constraints = constraints.copy(facingMode = constrain)
    }

    fun frameRate(ratio: Double) {
        frameRate { exact(ratio) }
    }

    fun frameRate(build: Constrain<Double>.() -> Unit) {
        val constrain = Constrain<Double>()
        build(constrain)
        constraints = constraints.copy(frameRate = constrain)
    }

    fun height(height: Int) {
        height { exact(height) }
    }

    fun height(build: Constrain<Int>.() -> Unit) {
        val constrain = Constrain<Int>()
        build(constrain)
        constraints = constraints.copy(height = constrain)
    }

    fun width(width: Int) {
        width { exact(width) }
    }

    fun width(build: Constrain<Int>.() -> Unit) {
        val constrain = Constrain<Int>()
        build(constrain)
        constraints = constraints.copy(width = constrain)
    }

    fun resizeMode(mode: ResizeMode) {
        resizeMode { exact(mode) }
    }

    fun resizeMode(build: Constrain<ResizeMode>.() -> Unit) {
        val constrain = Constrain<ResizeMode>()
        build(constrain)
        constraints = constraints.copy(resizeMode = constrain)
    }
}
