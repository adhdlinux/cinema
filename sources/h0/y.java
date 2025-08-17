package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29204a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29205b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29206c;

    public /* synthetic */ y(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        this.f29204a = eventTime;
        this.f29205b = i2;
        this.f29206c = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).v(this.f29204a, this.f29205b, this.f29206c);
    }
}
