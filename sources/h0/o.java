package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29163b;

    public /* synthetic */ o(AnalyticsListener.EventTime eventTime, String str) {
        this.f29162a = eventTime;
        this.f29163b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).q0(this.f29162a, this.f29163b);
    }
}
