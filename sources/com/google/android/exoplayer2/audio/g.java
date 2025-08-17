package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f23910c;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f23909b = eventDispatcher;
        this.f23910c = decoderCounters;
    }

    public final void run() {
        this.f23909b.w(this.f23910c);
    }
}
