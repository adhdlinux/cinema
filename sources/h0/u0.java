package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f29190b;

    public /* synthetic */ u0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f29189a = eventTime;
        this.f29190b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).d(this.f29189a, this.f29190b);
    }
}
