package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f29168b;

    public /* synthetic */ p(AnalyticsListener.EventTime eventTime, long j2) {
        this.f29167a = eventTime;
        this.f29168b = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).s(this.f29167a, this.f29168b);
    }
}
