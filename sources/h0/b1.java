package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29083a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f29084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29085c;

    public /* synthetic */ b1(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        this.f29083a = eventTime;
        this.f29084b = obj;
        this.f29085c = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).v0(this.f29083a, this.f29084b, this.f29085c);
    }
}
