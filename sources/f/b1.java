package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class b1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21747a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f21748b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21749c;

    public /* synthetic */ b1(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        this.f21747a = eventTime;
        this.f21748b = obj;
        this.f21749c = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).a(this.f21747a, this.f21748b, this.f21749c);
    }
}
