package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21855a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21856b;

    public /* synthetic */ u0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f21855a = eventTime;
        this.f21856b = i2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.S1(this.f21855a, this.f21856b, (AnalyticsListener) obj);
    }
}
