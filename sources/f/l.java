package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f21808c;

    public /* synthetic */ l(AnalyticsListener.EventTime eventTime, int i2, boolean z2) {
        this.f21806a = eventTime;
        this.f21807b = i2;
        this.f21808c = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).d(this.f21806a, this.f21807b, this.f21808c);
    }
}
