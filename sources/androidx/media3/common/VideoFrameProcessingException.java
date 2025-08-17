package androidx.media3.common;

public final class VideoFrameProcessingException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    public final long f4482b;

    public VideoFrameProcessingException(Throwable th, long j2) {
        super(th);
        this.f4482b = j2;
    }

    public static VideoFrameProcessingException a(Exception exc) {
        return b(exc, -9223372036854775807L);
    }

    public static VideoFrameProcessingException b(Exception exc, long j2) {
        if (exc instanceof VideoFrameProcessingException) {
            return (VideoFrameProcessingException) exc;
        }
        return new VideoFrameProcessingException(exc, j2);
    }
}
