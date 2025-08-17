package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29122a;

    public /* synthetic */ h1(AnalyticsListener.EventTime eventTime) {
        this.f29122a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).e(this.f29122a);
    }
}
