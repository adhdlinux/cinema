package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29109c;

    public /* synthetic */ f0(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        this.f29107a = eventTime;
        this.f29108b = i2;
        this.f29109c = i3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).t(this.f29107a, this.f29108b, this.f29109c);
    }
}
