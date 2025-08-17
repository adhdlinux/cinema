package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21848a;

    public /* synthetic */ s0(AnalyticsListener.EventTime eventTime) {
        this.f21848a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m(this.f21848a);
    }
}
