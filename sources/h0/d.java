package h0;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f29094b;

    public /* synthetic */ d(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f29093a = eventTime;
        this.f29094b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).i(this.f29093a, this.f29094b);
    }
}
