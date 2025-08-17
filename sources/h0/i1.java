package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29126a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f29127b;

    public /* synthetic */ i1(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f29126a = eventTime;
        this.f29127b = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).x(this.f29126a, this.f29127b);
    }
}
