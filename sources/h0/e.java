package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29100b;

    public /* synthetic */ e(AnalyticsListener.EventTime eventTime, String str) {
        this.f29099a = eventTime;
        this.f29100b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).a(this.f29099a, this.f29100b);
    }
}
