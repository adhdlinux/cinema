package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21762a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f21763b;

    public /* synthetic */ e(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f21762a = eventTime;
        this.f21763b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).D(this.f21762a, this.f21763b);
    }
}
