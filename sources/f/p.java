package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21830b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21831c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f21832d;

    public /* synthetic */ p(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f21829a = eventTime;
        this.f21830b = str;
        this.f21831c = j2;
        this.f21832d = j3;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.x2(this.f21829a, this.f21830b, this.f21831c, this.f21832d, (AnalyticsListener) obj);
    }
}
