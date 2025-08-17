package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21846a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f21847b;

    public /* synthetic */ s(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f21846a = eventTime;
        this.f21847b = decoderCounters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).E(this.f21846a, this.f21847b);
    }
}
