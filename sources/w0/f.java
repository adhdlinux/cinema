package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29240b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f29241c;

    public /* synthetic */ f(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f29240b = eventDispatcher;
        this.f29241c = str;
    }

    public final void run() {
        this.f29240b.r(this.f29241c);
    }
}
