package h0;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaItem f29200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29201c;

    public /* synthetic */ x(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        this.f29199a = eventTime;
        this.f29200b = mediaItem;
        this.f29201c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).F(this.f29199a, this.f29200b, this.f29201c);
    }
}
