package h0;

import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Tracks f29175b;

    public /* synthetic */ r(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        this.f29174a = eventTime;
        this.f29175b = tracks;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).G(this.f29174a, this.f29175b);
    }
}
