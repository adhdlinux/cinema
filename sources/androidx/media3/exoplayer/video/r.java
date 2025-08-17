package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7785b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7786c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7787d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f7788e;

    public /* synthetic */ r(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.f7785b = eventDispatcher;
        this.f7786c = str;
        this.f7787d = j2;
        this.f7788e = j3;
    }

    public final void run() {
        this.f7785b.q(this.f7786c, this.f7787d, this.f7788e);
    }
}
