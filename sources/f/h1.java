package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class h1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21787a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21788b;

    public /* synthetic */ h1(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f21787a = eventTime;
        this.f21788b = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).h(this.f21787a, this.f21788b);
    }
}
