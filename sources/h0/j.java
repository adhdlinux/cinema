package h0;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29128a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f29129b;

    public /* synthetic */ j(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f29128a = eventTime;
        this.f29129b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).S(this.f29128a, this.f29129b);
    }
}
