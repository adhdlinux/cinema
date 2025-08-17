package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21877a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21878b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21879c;

    public /* synthetic */ z(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        this.f21877a = eventTime;
        this.f21878b = z2;
        this.f21879c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).k(this.f21877a, this.f21878b, this.f21879c);
    }
}
