package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29211a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f29212b;

    public /* synthetic */ z(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f29211a = eventTime;
        this.f29212b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.h2(this.f29211a, this.f29212b, (AnalyticsListener) obj);
    }
}
