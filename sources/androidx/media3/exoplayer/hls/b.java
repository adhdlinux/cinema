package androidx.media3.exoplayer.hls;

import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper.Callback f6463b;

    public /* synthetic */ b(HlsSampleStreamWrapper.Callback callback) {
        this.f6463b = callback;
    }

    public final void run() {
        this.f6463b.a();
    }
}
