package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl f7763b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSink.Listener f7764c;

    public /* synthetic */ e(CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSink.Listener listener) {
        this.f7763b = videoSinkImpl;
        this.f7764c = listener;
    }

    public final void run() {
        this.f7763b.A(this.f7764c);
    }
}
