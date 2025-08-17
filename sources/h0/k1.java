package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29141a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f29142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29143c;

    public /* synthetic */ k1(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        this.f29141a = eventTime;
        this.f29142b = j2;
        this.f29143c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).b(this.f29141a, this.f29142b, this.f29143c);
    }
}
