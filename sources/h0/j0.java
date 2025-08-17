package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;
import java.io.IOException;

public final /* synthetic */ class j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29130a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f29131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f29132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f29133d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f29134e;

    public /* synthetic */ j0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f29130a = eventTime;
        this.f29131b = loadEventInfo;
        this.f29132c = mediaLoadData;
        this.f29133d = iOException;
        this.f29134e = z2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).k(this.f29130a, this.f29131b, this.f29132c, this.f29133d, this.f29134e);
    }
}
