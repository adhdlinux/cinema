package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class i1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21793a;

    public /* synthetic */ i1(AnalyticsListener.EventTime eventTime) {
        this.f21793a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).U(this.f21793a);
    }
}
