package w0;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29236b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29237c;

    public /* synthetic */ d(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f29236b = eventDispatcher;
        this.f29237c = decoderCounters;
    }

    public final void run() {
        this.f29236b.s(this.f29237c);
    }
}
