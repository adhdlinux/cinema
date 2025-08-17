package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29198a;

    public /* synthetic */ w0(AnalyticsListener.EventTime eventTime) {
        this.f29198a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).P(this.f29198a);
    }
}
