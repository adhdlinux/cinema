package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class f1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21773a;

    public /* synthetic */ f1(AnalyticsListener.EventTime eventTime) {
        this.f21773a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).q0(this.f21773a);
    }
}
