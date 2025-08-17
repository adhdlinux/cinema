package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21800a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f21801b;

    public /* synthetic */ k(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f21800a = eventTime;
        this.f21801b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).o(this.f21800a, this.f21801b);
    }
}
