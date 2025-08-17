package e;

import android.content.Context;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21737b;

    public /* synthetic */ o(Context context) {
        this.f21737b = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.n(this.f21737b);
    }
}
