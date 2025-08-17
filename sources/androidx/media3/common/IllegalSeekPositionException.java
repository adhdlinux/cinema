package androidx.media3.common;

public final class IllegalSeekPositionException extends IllegalStateException {

    /* renamed from: b  reason: collision with root package name */
    public final Timeline f4064b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4065c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4066d;

    public IllegalSeekPositionException(Timeline timeline, int i2, long j2) {
        this.f4064b = timeline;
        this.f4065c = i2;
        this.f4066d = j2;
    }
}
