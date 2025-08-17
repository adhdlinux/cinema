package w0;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29239c;

    public /* synthetic */ e(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f29238b = eventDispatcher;
        this.f29239c = decoderCounters;
    }

    public final void run() {
        this.f29238b.u(this.f29239c);
    }
}
