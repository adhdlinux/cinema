package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29186b;

    public /* synthetic */ t0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f29185a = eventTime;
        this.f29186b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).q(this.f29185a, this.f29186b);
    }
}
