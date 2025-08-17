package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29117a;

    public /* synthetic */ g1(AnalyticsListener.EventTime eventTime) {
        this.f29117a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).K(this.f29117a);
    }
}
