package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21819a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21820b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21821c;

    public /* synthetic */ n0(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        this.f21819a = eventTime;
        this.f21820b = i2;
        this.f21821c = i3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).z(this.f21819a, this.f21820b, this.f21821c);
    }
}
