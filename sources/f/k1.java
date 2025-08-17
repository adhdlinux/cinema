package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class k1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21805b;

    public /* synthetic */ k1(AnalyticsListener.EventTime eventTime, String str) {
        this.f21804a = eventTime;
        this.f21805b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).R(this.f21804a, this.f21805b);
    }
}
