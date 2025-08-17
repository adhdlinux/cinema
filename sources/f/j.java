package f;

import androidx.media3.common.Tracks;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Tracks f21795b;

    public /* synthetic */ j(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        this.f21794a = eventTime;
        this.f21795b = tracks;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).f0(this.f21794a, this.f21795b);
    }
}
