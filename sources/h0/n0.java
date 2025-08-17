package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29158a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29159b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29160c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29161d;

    public /* synthetic */ n0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f29158a = eventTime;
        this.f29159b = i2;
        this.f29160c = j2;
        this.f29161d = j3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).L(this.f29158a, this.f29159b, this.f29160c, this.f29161d);
    }
}
