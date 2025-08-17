package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21837a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21838b;

    public /* synthetic */ q0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f21837a = eventTime;
        this.f21838b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).T(this.f21837a, this.f21838b);
    }
}
