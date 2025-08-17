package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7770b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7771c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7772d;

    public /* synthetic */ l(VideoRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2) {
        this.f7770b = eventDispatcher;
        this.f7771c = i2;
        this.f7772d = j2;
    }

    public final void run() {
        this.f7770b.t(this.f7771c, this.f7772d);
    }
}
