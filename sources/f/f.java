package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21769a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f21770b;

    public /* synthetic */ f(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f21769a = eventTime;
        this.f21770b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).F(this.f21769a, this.f21770b);
    }
}
