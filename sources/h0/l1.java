package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29149a;

    public /* synthetic */ l1(AnalyticsListener.EventTime eventTime) {
        this.f29149a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).E(this.f29149a);
    }
}
