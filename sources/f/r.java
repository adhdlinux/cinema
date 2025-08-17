package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21839a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21840b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21841c;

    public /* synthetic */ r(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        this.f21839a = eventTime;
        this.f21840b = i2;
        this.f21841c = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).X(this.f21839a, this.f21840b, this.f21841c);
    }
}
