package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class e1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21766a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21768c;

    public /* synthetic */ e1(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        this.f21766a = eventTime;
        this.f21767b = z2;
        this.f21768c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).a0(this.f21766a, this.f21767b, this.f21768c);
    }
}
