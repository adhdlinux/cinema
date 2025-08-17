package f;

import androidx.media3.common.DeviceInfo;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f21790b;

    public /* synthetic */ i(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        this.f21789a = eventTime;
        this.f21790b = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).o0(this.f21789a, this.f21790b);
    }
}
