package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f21743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21744c;

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        this.f21742a = eventTime;
        this.f21743b = j2;
        this.f21744c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).l0(this.f21742a, this.f21743b, this.f21744c);
    }
}
