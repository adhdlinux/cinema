package androidx.media3.exoplayer.drm;

public final class UnsupportedDrmException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    public final int f6251b;

    public UnsupportedDrmException(int i2) {
        this.f6251b = i2;
    }

    public UnsupportedDrmException(int i2, Exception exc) {
        super(exc);
        this.f6251b = i2;
    }
}
