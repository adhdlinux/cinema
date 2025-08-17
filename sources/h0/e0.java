package h0;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29101a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.Commands f29102b;

    public /* synthetic */ e0(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        this.f29101a = eventTime;
        this.f29102b = commands;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).u0(this.f29101a, this.f29102b);
    }
}
