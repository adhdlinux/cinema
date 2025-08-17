package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f29253c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29254d;

    public /* synthetic */ k(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j2) {
        this.f29252b = eventDispatcher;
        this.f29253c = obj;
        this.f29254d = j2;
    }

    public final void run() {
        this.f29252b.w(this.f29253c, this.f29254d);
    }
}
