package f;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f21776c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f21777d;

    public /* synthetic */ g(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f21774a = eventTime;
        this.f21775b = i2;
        this.f21776c = positionInfo;
        this.f21777d = positionInfo2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.m2(this.f21774a, this.f21775b, this.f21776c, this.f21777d, (AnalyticsListener) obj);
    }
}
