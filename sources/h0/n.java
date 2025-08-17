package h0;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAnalyticsCollector f29156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player f29157b;

    public /* synthetic */ n(DefaultAnalyticsCollector defaultAnalyticsCollector, Player player) {
        this.f29156a = defaultAnalyticsCollector;
        this.f29157b = player;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f29156a.o2(this.f29157b, (AnalyticsListener) obj, flagSet);
    }
}
