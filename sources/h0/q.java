package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29171a;

    public /* synthetic */ q(AnalyticsListener.EventTime eventTime) {
        this.f29171a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).V(this.f29171a);
    }
}
