package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29119b;

    public /* synthetic */ h(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f29118a = eventTime;
        this.f29119b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.i2(this.f29118a, this.f29119b, (AnalyticsListener) obj);
    }
}
