package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f23908c;

    public /* synthetic */ f(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f23907b = eventDispatcher;
        this.f23908c = decoderCounters;
    }

    public final void run() {
        this.f23907b.v(this.f23908c);
    }
}
