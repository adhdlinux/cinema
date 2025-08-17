package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21867c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f21868d;

    public /* synthetic */ w0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f21865a = eventTime;
        this.f21866b = i2;
        this.f21867c = j2;
        this.f21868d = j3;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).n(this.f21865a, this.f21866b, this.f21867c, this.f21868d);
    }
}
