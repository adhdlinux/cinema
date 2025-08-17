package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl f7765b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSink.Listener f7766c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ VideoSize f7767d;

    public /* synthetic */ f(CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSink.Listener listener, VideoSize videoSize) {
        this.f7765b = videoSinkImpl;
        this.f7766c = listener;
        this.f7767d = videoSize;
    }

    public final void run() {
        this.f7765b.B(this.f7766c, this.f7767d);
    }
}
