package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29147a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f29148b;

    public /* synthetic */ l0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f29147a = eventTime;
        this.f29148b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).l0(this.f29147a, this.f29148b);
    }
}
