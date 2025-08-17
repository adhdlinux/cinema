package h0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29164a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f29165b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f29166c;

    public /* synthetic */ o0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f29164a = eventTime;
        this.f29165b = format;
        this.f29166c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.k2(this.f29164a, this.f29165b, this.f29166c, (AnalyticsListener) obj);
    }
}
