package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29255b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29256c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29257d;

    public /* synthetic */ l(VideoRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2) {
        this.f29255b = eventDispatcher;
        this.f29256c = i2;
        this.f29257d = j2;
    }

    public final void run() {
        this.f29255b.t(this.f29256c, this.f29257d);
    }
}
