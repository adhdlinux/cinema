package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21746b;

    public /* synthetic */ b0(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f21745a = eventTime;
        this.f21746b = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).G(this.f21745a, this.f21746b);
    }
}
