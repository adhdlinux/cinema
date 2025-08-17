package f;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21757a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaItem f21758b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21759c;

    public /* synthetic */ d0(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        this.f21757a = eventTime;
        this.f21758b = mediaItem;
        this.f21759c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).w(this.f21757a, this.f21758b, this.f21759c);
    }
}
