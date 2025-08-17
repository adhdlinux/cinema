package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5881b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5882c;

    public /* synthetic */ n(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f5881b = eventDispatcher;
        this.f5882c = str;
    }

    public final void run() {
        this.f5881b.A(this.f5882c);
    }
}
