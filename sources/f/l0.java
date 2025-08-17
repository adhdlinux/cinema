package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class l0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21809a;

    public /* synthetic */ l0(AnalyticsListener.EventTime eventTime) {
        this.f21809a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).d0(this.f21809a);
    }
}
