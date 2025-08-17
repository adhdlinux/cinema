package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class y0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21874a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f21875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21876c;

    public /* synthetic */ y0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f21874a = eventTime;
        this.f21875b = loadEventInfo;
        this.f21876c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).r0(this.f21874a, this.f21875b, this.f21876c);
    }
}
