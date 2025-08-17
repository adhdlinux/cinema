package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7776b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f7777c;

    public /* synthetic */ n(VideoRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f7776b = eventDispatcher;
        this.f7777c = exc;
    }

    public final void run() {
        this.f7776b.y(this.f7777c);
    }
}
