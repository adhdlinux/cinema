package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f7784c;

    public /* synthetic */ q(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f7783b = eventDispatcher;
        this.f7784c = decoderCounters;
    }

    public final void run() {
        this.f7783b.s(this.f7784c);
    }
}
