package f;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class n implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAnalyticsCollector f21817a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player f21818b;

    public /* synthetic */ n(DefaultAnalyticsCollector defaultAnalyticsCollector, Player player) {
        this.f21817a = defaultAnalyticsCollector;
        this.f21818b = player;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f21817a.F2(this.f21818b, (AnalyticsListener) obj, flagSet);
    }
}
