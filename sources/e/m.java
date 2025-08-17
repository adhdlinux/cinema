package e;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21736b;

    public /* synthetic */ m(Context context) {
        this.f21736b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.k(this.f21736b);
    }
}
