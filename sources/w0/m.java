package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f29259c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29260d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f29261e;

    public /* synthetic */ m(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.f29258b = eventDispatcher;
        this.f29259c = str;
        this.f29260d = j2;
        this.f29261e = j3;
    }

    public final void run() {
        this.f29258b.q(this.f29259c, this.f29260d, this.f29261e);
    }
}
