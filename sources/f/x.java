package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21870b;

    public /* synthetic */ x(AnalyticsListener.EventTime eventTime, int i2) {
        this.f21869a = eventTime;
        this.f21870b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).S(this.f21869a, this.f21870b);
    }
}
