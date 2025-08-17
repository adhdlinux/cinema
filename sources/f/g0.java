package f;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21778a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f21779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f21780c;

    public /* synthetic */ g0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f21778a = eventTime;
        this.f21779b = format;
        this.f21780c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).L(this.f21778a, this.f21779b, this.f21780c);
    }
}
