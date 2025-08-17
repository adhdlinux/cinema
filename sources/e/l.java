package e;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import com.google.common.base.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelector f21735b;

    public /* synthetic */ l(TrackSelector trackSelector) {
        this.f21735b = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.o(this.f21735b);
    }
}
