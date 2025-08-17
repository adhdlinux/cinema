package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f21813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21814c;

    public /* synthetic */ m(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f21812a = eventTime;
        this.f21813b = loadEventInfo;
        this.f21814c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).Z(this.f21812a, this.f21813b, this.f21814c);
    }
}
