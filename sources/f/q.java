package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21836b;

    public /* synthetic */ q(AnalyticsListener.EventTime eventTime, int i2) {
        this.f21835a = eventTime;
        this.f21836b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).t(this.f21835a, this.f21836b);
    }
}
