package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5886b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f5887c;

    public /* synthetic */ p(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z2) {
        this.f5886b = eventDispatcher;
        this.f5887c = z2;
    }

    public final void run() {
        this.f5886b.F(this.f5887c);
    }
}
