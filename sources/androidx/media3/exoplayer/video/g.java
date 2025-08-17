package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl f7768b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSink.Listener f7769c;

    public /* synthetic */ g(CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSink.Listener listener) {
        this.f7768b = videoSinkImpl;
        this.f7769c = listener;
    }

    public final void run() {
        this.f7768b.z(this.f7769c);
    }
}
