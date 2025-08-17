package f;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f21816b;

    public /* synthetic */ m0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f21815a = eventTime;
        this.f21816b = decoderCounters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).l(this.f21815a, this.f21816b);
    }
}
