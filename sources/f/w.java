package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21863a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f21864b;

    public /* synthetic */ w(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f21863a = eventTime;
        this.f21864b = decoderCounters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).x(this.f21863a, this.f21864b);
    }
}
