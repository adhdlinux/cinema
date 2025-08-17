package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29191a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29192b;

    public /* synthetic */ v(AnalyticsListener.EventTime eventTime, int i2) {
        this.f29191a = eventTime;
        this.f29192b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).f(this.f29191a, this.f29192b);
    }
}
