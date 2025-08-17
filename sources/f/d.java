package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21756b;

    public /* synthetic */ d(AnalyticsListener.EventTime eventTime, int i2) {
        this.f21755a = eventTime;
        this.f21756b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).h0(this.f21755a, this.f21756b);
    }
}
