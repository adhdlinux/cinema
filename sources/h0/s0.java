package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29180a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f29181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29182c;

    public /* synthetic */ s0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f29180a = eventTime;
        this.f29181b = loadEventInfo;
        this.f29182c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).Q(this.f29180a, this.f29181b, this.f29182c);
    }
}
