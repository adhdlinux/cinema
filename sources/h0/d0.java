package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29095a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29096b;

    public /* synthetic */ d0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f29095a = eventTime;
        this.f29096b = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).b0(this.f29095a, this.f29096b);
    }
}
