package f;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class a1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoSize f21741b;

    public /* synthetic */ a1(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f21740a = eventTime;
        this.f21741b = videoSize;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.D2(this.f21740a, this.f21741b, (AnalyticsListener) obj);
    }
}
