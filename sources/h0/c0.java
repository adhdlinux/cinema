package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29091b;

    public /* synthetic */ c0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f29090a = eventTime;
        this.f29091b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.k1(this.f29090a, this.f29091b, (AnalyticsListener) obj);
    }
}
