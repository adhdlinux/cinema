package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29081a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29082b;

    public /* synthetic */ b0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f29081a = eventTime;
        this.f29082b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).o0(this.f29081a, this.f29082b);
    }
}
