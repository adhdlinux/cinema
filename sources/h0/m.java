package h0;

import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29150a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f29151b;

    public /* synthetic */ m(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        this.f29150a = eventTime;
        this.f29151b = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).x0(this.f29150a, this.f29151b);
    }
}
