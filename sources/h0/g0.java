package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29114a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f29115b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29116c;

    public /* synthetic */ g0(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        this.f29114a = eventTime;
        this.f29115b = z2;
        this.f29116c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).z(this.f29114a, this.f29115b, this.f29116c);
    }
}
