package f;

import androidx.media3.common.FlagSet;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class m1 implements ListenerSet.IterationFinishedEvent {
    public final void a(Object obj, FlagSet flagSet) {
        DefaultAnalyticsCollector.v1((AnalyticsListener) obj, flagSet);
    }
}
