package h0;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29103a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f29104b;

    public /* synthetic */ e1(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f29103a = eventTime;
        this.f29104b = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).h(this.f29103a, this.f29104b);
    }
}
