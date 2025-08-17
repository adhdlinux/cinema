package f;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class j1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f21798b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f21799c;

    public /* synthetic */ j1(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f21797a = eventTime;
        this.f21798b = format;
        this.f21799c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).t0(this.f21797a, this.f21798b, this.f21799c);
    }
}
