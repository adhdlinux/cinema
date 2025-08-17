package f;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Metadata f21854b;

    public /* synthetic */ u(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f21853a = eventTime;
        this.f21854b = metadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).f(this.f21853a, this.f21854b);
    }
}
