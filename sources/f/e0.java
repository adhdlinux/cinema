package f;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21764a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f21765b;

    public /* synthetic */ e0(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f21764a = eventTime;
        this.f21765b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).b0(this.f21764a, this.f21765b);
    }
}
