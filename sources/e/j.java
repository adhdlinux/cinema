package e;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21733b;

    public /* synthetic */ j(Context context) {
        this.f21733b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.j(this.f21733b);
    }
}
