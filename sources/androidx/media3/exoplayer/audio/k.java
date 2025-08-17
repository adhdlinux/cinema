package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5871b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5872c;

    public /* synthetic */ k(AudioRendererEventListener.EventDispatcher eventDispatcher, long j2) {
        this.f5871b = eventDispatcher;
        this.f5872c = j2;
    }

    public final void run() {
        this.f5871b.E(this.f5872c);
    }
}
