package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29153b;

    public /* synthetic */ m0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f29152a = eventTime;
        this.f29153b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.j1(this.f29152a, this.f29153b, (AnalyticsListener) obj);
    }
}
