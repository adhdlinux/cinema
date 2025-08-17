package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21861a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21862b;

    public /* synthetic */ v0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f21861a = eventTime;
        this.f21862b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m0(this.f21861a, this.f21862b);
    }
}
