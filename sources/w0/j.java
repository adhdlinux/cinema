package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29250b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f29251c;

    public /* synthetic */ j(VideoRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f29250b = eventDispatcher;
        this.f29251c = exc;
    }

    public final void run() {
        this.f29250b.y(this.f29251c);
    }
}
