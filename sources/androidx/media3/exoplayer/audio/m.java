package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f5880c;

    public /* synthetic */ m(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f5879b = eventDispatcher;
        this.f5880c = exc;
    }

    public final void run() {
        this.f5879b.w(this.f5880c);
    }
}
