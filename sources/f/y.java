package f;

import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21872a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CueGroup f21873b;

    public /* synthetic */ y(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        this.f21872a = eventTime;
        this.f21873b = cueGroup;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).i0(this.f21872a, this.f21873b);
    }
}
