package androidx.media3.exoplayer.hls;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper f6464b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HlsMediaChunk f6465c;

    public /* synthetic */ c(HlsSampleStreamWrapper hlsSampleStreamWrapper, HlsMediaChunk hlsMediaChunk) {
        this.f6464b = hlsSampleStreamWrapper;
        this.f6465c = hlsMediaChunk;
    }

    public final void run() {
        this.f6464b.T(this.f6465c);
    }
}
