package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f21803b;

    public /* synthetic */ k0(AnalyticsListener.EventTime eventTime, long j2) {
        this.f21802a = eventTime;
        this.f21803b = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).J(this.f21802a, this.f21803b);
    }
}
