package f;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21849a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f21850b;

    public /* synthetic */ t(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f21849a = eventTime;
        this.f21850b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).i(this.f21849a, this.f21850b);
    }
}
