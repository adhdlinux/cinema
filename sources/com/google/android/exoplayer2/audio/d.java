package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f23902b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f23903c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f23904d;

    public /* synthetic */ d(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f23902b = eventDispatcher;
        this.f23903c = format;
        this.f23904d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f23902b.x(this.f23903c, this.f23904d);
    }
}
