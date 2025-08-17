package androidx.media3.common;

public interface VideoGraph {

    public interface Listener {
    }

    VideoFrameProcessor a(int i2);

    void c(int i2) throws VideoFrameProcessingException;

    void d(SurfaceInfo surfaceInfo);

    void release();
}
