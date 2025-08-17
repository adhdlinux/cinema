package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.List;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21822a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f21823b;

    public /* synthetic */ o(AnalyticsListener.EventTime eventTime, List list) {
        this.f21822a = eventTime;
        this.f21823b = list;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).g(this.f21822a, this.f21823b);
    }
}
