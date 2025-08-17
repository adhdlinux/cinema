package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29245c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f29246d;

    public /* synthetic */ h(VideoRendererEventListener.EventDispatcher eventDispatcher, long j2, int i2) {
        this.f29244b = eventDispatcher;
        this.f29245c = j2;
        this.f29246d = i2;
    }

    public final void run() {
        this.f29244b.x(this.f29245c, this.f29246d);
    }
}
