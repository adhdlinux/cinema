package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21852b;

    public /* synthetic */ t0(AnalyticsListener.EventTime eventTime, String str) {
        this.f21851a = eventTime;
        this.f21852b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).P(this.f21851a, this.f21852b);
    }
}
