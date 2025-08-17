package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5888b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5889c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5890d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f5891e;

    public /* synthetic */ q(AudioRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2, long j3) {
        this.f5888b = eventDispatcher;
        this.f5889c = i2;
        this.f5890d = j2;
        this.f5891e = j3;
    }

    public final void run() {
        this.f5888b.G(this.f5889c, this.f5890d, this.f5891e);
    }
}
