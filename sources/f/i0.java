package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21791a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21792b;

    public /* synthetic */ i0(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f21791a = eventTime;
        this.f21792b = z2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.W1(this.f21791a, this.f21792b, (AnalyticsListener) obj);
    }
}
