package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7884b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7885c;

    public /* synthetic */ u(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f7884b = eventDispatcher;
        this.f7885c = str;
    }

    public final void run() {
        this.f7884b.r(this.f7885c);
    }
}
