package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29144a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f29145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29146c;

    public /* synthetic */ l(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f29144a = eventTime;
        this.f29145b = loadEventInfo;
        this.f29146c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).j0(this.f29144a, this.f29145b, this.f29146c);
    }
}
