package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29120a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CueGroup f29121b;

    public /* synthetic */ h0(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        this.f29120a = eventTime;
        this.f29121b = cueGroup;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).U(this.f29120a, this.f29121b);
    }
}
