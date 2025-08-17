package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f21881b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21882c;

    public /* synthetic */ z0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f21880a = eventTime;
        this.f21881b = loadEventInfo;
        this.f21882c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).p(this.f21880a, this.f21881b, this.f21882c);
    }
}
