package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29137a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29138b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29139c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29140d;

    public /* synthetic */ k(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f29137a = eventTime;
        this.f29138b = str;
        this.f29139c = j2;
        this.f29140d = j3;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.h1(this.f29137a, this.f29138b, this.f29139c, this.f29140d, (AnalyticsListener) obj);
    }
}
