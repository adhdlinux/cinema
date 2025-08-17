package androidx.media3.exoplayer.video;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f7790c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f7791d;

    public /* synthetic */ s(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f7789b = eventDispatcher;
        this.f7790c = format;
        this.f7791d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f7789b.v(this.f7790c, this.f7791d);
    }
}
