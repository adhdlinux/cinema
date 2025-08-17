package f;

import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21750a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f21751b;

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        this.f21750a = eventTime;
        this.f21751b = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).r(this.f21750a, this.f21751b);
    }
}
