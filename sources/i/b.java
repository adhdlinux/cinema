package i;

import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;

public final /* synthetic */ class b implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f21893a;

    public /* synthetic */ b(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f21893a = defaultBandwidthMeter;
    }

    public final void a(int i2) {
        this.f21893a.q(i2);
    }
}
