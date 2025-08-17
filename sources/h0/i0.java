package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29124a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f29125b;

    public /* synthetic */ i0(AnalyticsListener.EventTime eventTime, float f2) {
        this.f29124a = eventTime;
        this.f29125b = f2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).i0(this.f29124a, this.f29125b);
    }
}
