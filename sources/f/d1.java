package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class d1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21760a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f21761b;

    public /* synthetic */ d1(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f21760a = eventTime;
        this.f21761b = audioTrackConfig;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).N(this.f21760a, this.f21761b);
    }
}
