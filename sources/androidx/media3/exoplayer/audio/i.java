package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f5862c;

    public /* synthetic */ i(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f5861b = eventDispatcher;
        this.f5862c = decoderCounters;
    }

    public final void run() {
        this.f5861b.B(this.f5862c);
    }
}
