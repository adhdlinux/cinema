package w0;

import android.view.Display;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;

public final /* synthetic */ class b implements VideoFrameReleaseHelper.DisplayHelper.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoFrameReleaseHelper f29235a;

    public /* synthetic */ b(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.f29235a = videoFrameReleaseHelper;
    }

    public final void a(Display display) {
        this.f29235a.p(display);
    }
}
