package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29111a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29112b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f29113c;

    public /* synthetic */ g(AnalyticsListener.EventTime eventTime, int i2, boolean z2) {
        this.f29111a = eventTime;
        this.f29112b = i2;
        this.f29113c = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).M(this.f29111a, this.f29112b, this.f29113c);
    }
}
