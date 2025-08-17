package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7778b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f7779c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f7780d;

    public /* synthetic */ o(VideoRendererEventListener.EventDispatcher eventDispatcher, long j2, int i2) {
        this.f7778b = eventDispatcher;
        this.f7779c = j2;
        this.f7780d = i2;
    }

    public final void run() {
        this.f7778b.x(this.f7779c, this.f7780d);
    }
}
