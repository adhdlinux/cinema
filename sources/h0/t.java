package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29183a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f29184b;

    public /* synthetic */ t(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f29183a = eventTime;
        this.f29184b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).w(this.f29183a, this.f29184b);
    }
}
