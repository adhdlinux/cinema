package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f29179b;

    public /* synthetic */ s(AnalyticsListener.EventTime eventTime, boolean z2) {
        this.f29178a = eventTime;
        this.f29179b = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).k0(this.f29178a, this.f29179b);
    }
}
