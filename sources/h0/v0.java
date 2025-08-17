package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29193a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29194b;

    public /* synthetic */ v0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f29193a = eventTime;
        this.f29194b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).D(this.f29193a, this.f29194b);
    }
}
