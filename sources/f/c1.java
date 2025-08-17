package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class c1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21754a;

    public /* synthetic */ c1(AnalyticsListener.EventTime eventTime) {
        this.f21754a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).e0(this.f21754a);
    }
}
