package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29086a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f29088c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f29089d;

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f29086a = eventTime;
        this.f29087b = str;
        this.f29088c = j2;
        this.f29089d = j3;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.f2(this.f29086a, this.f29087b, this.f29088c, this.f29089d, (AnalyticsListener) obj);
    }
}
