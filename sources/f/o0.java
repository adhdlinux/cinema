package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

public final /* synthetic */ class o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21824a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f21825b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f21826c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f21827d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f21828e;

    public /* synthetic */ o0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f21824a = eventTime;
        this.f21825b = loadEventInfo;
        this.f21826c = mediaLoadData;
        this.f21827d = iOException;
        this.f21828e = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).I(this.f21824a, this.f21825b, this.f21826c, this.f21827d, this.f21828e);
    }
}
