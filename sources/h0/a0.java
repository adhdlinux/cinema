package h0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29072a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f29073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f29074c;

    public /* synthetic */ a0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f29072a = eventTime;
        this.f29073b = format;
        this.f29074c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.l1(this.f29072a, this.f29073b, this.f29074c, (AnalyticsListener) obj);
    }
}
