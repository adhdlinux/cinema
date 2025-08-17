package e;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RenderersFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RenderersFactory f21734b;

    public /* synthetic */ k(RenderersFactory renderersFactory) {
        this.f21734b = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.n(this.f21734b);
    }
}
