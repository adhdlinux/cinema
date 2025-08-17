package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class d1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoSize f29098b;

    public /* synthetic */ d1(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f29097a = eventTime;
        this.f29098b = videoSize;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.l2(this.f29097a, this.f29098b, (AnalyticsListener) obj);
    }
}
