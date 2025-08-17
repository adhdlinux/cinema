package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29079a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Metadata f29080b;

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f29079a = eventTime;
        this.f29080b = metadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).n(this.f29079a, this.f29080b);
    }
}
