package w0;

import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f29242b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSize f29243c;

    public /* synthetic */ g(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f29242b = eventDispatcher;
        this.f29243c = videoSize;
    }

    public final void run() {
        this.f29242b.z(this.f29243c);
    }
}
