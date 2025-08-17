package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21842a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21843b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21844c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f21845d;

    public /* synthetic */ r0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f21842a = eventTime;
        this.f21843b = i2;
        this.f21844c = j2;
        this.f21845d = j3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).K(this.f21842a, this.f21843b, this.f21844c, this.f21845d);
    }
}
