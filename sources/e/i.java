package e;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21732b;

    public /* synthetic */ i(Context context) {
        this.f21732b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.i(this.f21732b);
    }
}
