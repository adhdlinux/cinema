package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21833a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f21834b;

    public /* synthetic */ p0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f21833a = eventTime;
        this.f21834b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).u(this.f21833a, this.f21834b);
    }
}
