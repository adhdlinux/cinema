package androidx.media3.exoplayer.audio;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5883b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f5884c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f5885d;

    public /* synthetic */ o(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f5883b = eventDispatcher;
        this.f5884c = format;
        this.f5885d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f5883b.D(this.f5884c, this.f5885d);
    }
}
