package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f5855c;

    public /* synthetic */ f(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f5854b = eventDispatcher;
        this.f5855c = exc;
    }

    public final void run() {
        this.f5854b.v(this.f5855c);
    }
}
