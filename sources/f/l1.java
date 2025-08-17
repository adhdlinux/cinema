package f;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class l1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f21811b;

    public /* synthetic */ l1(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f21810a = eventTime;
        this.f21811b = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).O(this.f21810a, this.f21811b);
    }
}
