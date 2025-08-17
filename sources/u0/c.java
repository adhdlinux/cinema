package u0;

import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class c implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f29234a;

    public /* synthetic */ c(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f29234a = defaultBandwidthMeter;
    }

    public final void a(int i2) {
        this.f29234a.q(i2);
    }
}
