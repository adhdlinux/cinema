package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7781b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f7782c;

    public /* synthetic */ p(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f7781b = eventDispatcher;
        this.f7782c = decoderCounters;
    }

    public final void run() {
        this.f7781b.u(this.f7782c);
    }
}
