package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29077c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29078d;

    public /* synthetic */ a1(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f29075a = eventTime;
        this.f29076b = i2;
        this.f29077c = j2;
        this.f29078d = j3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).X(this.f29075a, this.f29076b, this.f29077c, this.f29078d);
    }
}
