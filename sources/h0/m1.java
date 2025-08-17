package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29154a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f29155b;

    public /* synthetic */ m1(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        this.f29154a = eventTime;
        this.f29155b = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).H(this.f29154a, this.f29155b);
    }
}
