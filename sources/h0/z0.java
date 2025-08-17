package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29213a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f29214b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29215c;

    public /* synthetic */ z0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f29213a = eventTime;
        this.f29214b = loadEventInfo;
        this.f29215c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).n0(this.f29213a, this.f29214b, this.f29215c);
    }
}
