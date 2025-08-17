package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f5869c;

    public /* synthetic */ j(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f5868b = eventDispatcher;
        this.f5869c = decoderCounters;
    }

    public final void run() {
        this.f5868b.C(this.f5869c);
    }
}
