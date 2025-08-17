package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21785a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f21786b;

    public /* synthetic */ h0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f21785a = eventTime;
        this.f21786b = decoderCounters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).v(this.f21785a, this.f21786b);
    }
}
