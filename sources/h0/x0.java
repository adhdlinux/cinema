package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class x0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f29203b;

    public /* synthetic */ x0(AnalyticsListener.EventTime eventTime, List list) {
        this.f29202a = eventTime;
        this.f29203b = list;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).y(this.f29202a, this.f29203b);
    }
}
