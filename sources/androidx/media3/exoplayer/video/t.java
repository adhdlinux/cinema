package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f7882b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSize f7883c;

    public /* synthetic */ t(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f7882b = eventDispatcher;
        this.f7883c = videoSize;
    }

    public final void run() {
        this.f7882b.z(this.f7883c);
    }
}
