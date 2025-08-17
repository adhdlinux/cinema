package h0;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k0 implements ListenerSet.IterationFinishedEvent {
    public final void a(Object obj, FlagSet flagSet) {
        DefaultAnalyticsCollector.e1((AnalyticsListener) obj, flagSet);
    }
}
