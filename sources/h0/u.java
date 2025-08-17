package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29188b;

    public /* synthetic */ u(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f29187a = eventTime;
        this.f29188b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m0(this.f29187a, this.f29188b);
    }
}
