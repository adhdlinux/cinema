package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f29196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29197c;

    public /* synthetic */ w(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        this.f29195a = eventTime;
        this.f29196b = z2;
        this.f29197c = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).p(this.f29195a, this.f29196b, this.f29197c);
    }
}
