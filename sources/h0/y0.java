package h0;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f29207a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f29209c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f29210d;

    public /* synthetic */ y0(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f29207a = eventTime;
        this.f29208b = i2;
        this.f29209c = positionInfo;
        this.f29210d = positionInfo2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.T1(this.f29207a, this.f29208b, this.f29209c, this.f29210d, (AnalyticsListener) obj);
    }
}
