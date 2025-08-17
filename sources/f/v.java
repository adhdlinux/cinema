package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21857a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21859c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f21860d;

    public /* synthetic */ v(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f21857a = eventTime;
        this.f21858b = str;
        this.f21859c = j2;
        this.f21860d = j3;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.y1(this.f21857a, this.f21858b, this.f21859c, this.f21860d, (AnalyticsListener) obj);
    }
}
