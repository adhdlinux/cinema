package w0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29247b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f29248c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f29249d;

    public /* synthetic */ i(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f29247b = eventDispatcher;
        this.f29248c = format;
        this.f29249d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f29247b.v(this.f29248c, this.f29249d);
    }
}
