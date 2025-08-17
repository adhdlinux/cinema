package f;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f21772b;

    public /* synthetic */ f0(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f21771a = eventTime;
        this.f21772b = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).s(this.f21771a, this.f21772b);
    }
}
