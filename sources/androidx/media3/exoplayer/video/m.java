package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f7774c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7775d;

    public /* synthetic */ m(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j2) {
        this.f7773b = eventDispatcher;
        this.f7774c = obj;
        this.f7775d = j2;
    }

    public final void run() {
        this.f7773b.w(this.f7774c, this.f7775d);
    }
}
