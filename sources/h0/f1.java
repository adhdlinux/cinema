package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29110a;

    public /* synthetic */ f1(AnalyticsListener.EventTime eventTime) {
        this.f29110a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).c0(this.f29110a);
    }
}
