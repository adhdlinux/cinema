package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21753b;

    public /* synthetic */ c0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f21752a = eventTime;
        this.f21753b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).H(this.f21752a, this.f21753b);
    }
}
