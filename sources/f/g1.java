package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class g1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f21782b;

    public /* synthetic */ g1(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f21781a = eventTime;
        this.f21782b = audioTrackConfig;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).Q(this.f21781a, this.f21782b);
    }
}
