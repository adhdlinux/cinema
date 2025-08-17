package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class x0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21871a;

    public /* synthetic */ x0(AnalyticsListener.EventTime eventTime) {
        this.f21871a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).y(this.f21871a);
    }
}
