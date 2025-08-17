package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29170b;

    public /* synthetic */ p0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f29169a = eventTime;
        this.f29170b = i2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.z1(this.f29169a, this.f29170b, (AnalyticsListener) obj);
    }
}
