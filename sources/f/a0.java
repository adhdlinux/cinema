package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21739b;

    public /* synthetic */ a0(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f21738a = eventTime;
        this.f21739b = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).e(this.f21738a, this.f21739b);
    }
}
