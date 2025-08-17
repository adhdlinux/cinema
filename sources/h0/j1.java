package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29135a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f29136b;

    public /* synthetic */ j1(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f29135a = eventTime;
        this.f29136b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).C(this.f29135a, this.f29136b);
    }
}
