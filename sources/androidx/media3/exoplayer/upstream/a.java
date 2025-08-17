package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.BandwidthMeter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f7570b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7571c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7572d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f7573e;

    public /* synthetic */ a(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i2, long j2, long j3) {
        this.f7570b = handlerAndListener;
        this.f7571c = i2;
        this.f7572d = j2;
        this.f7573e = j3;
    }

    public final void run() {
        this.f7570b.f7484b.p(this.f7571c, this.f7572d, this.f7573e);
    }
}
