package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29092a;

    public /* synthetic */ c1(AnalyticsListener.EventTime eventTime) {
        this.f29092a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).h0(this.f29092a);
    }
}
