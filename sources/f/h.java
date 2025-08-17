package f;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f21783a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.Commands f21784b;

    public /* synthetic */ h(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        this.f21783a = eventTime;
        this.f21784b = commands;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).C(this.f21783a, this.f21784b);
    }
}
