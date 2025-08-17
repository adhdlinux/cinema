package h0;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29176a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f29177b;

    public /* synthetic */ r0(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f29176a = eventTime;
        this.f29177b = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).W(this.f29176a, this.f29177b);
    }
}
