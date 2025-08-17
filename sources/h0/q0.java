package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29172a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f29173b;

    public /* synthetic */ q0(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f29172a = eventTime;
        this.f29173b = z2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.D1(this.f29172a, this.f29173b, (AnalyticsListener) obj);
    }
}
