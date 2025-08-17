package e;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import com.google.common.base.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadControl f21731b;

    public /* synthetic */ h(LoadControl loadControl) {
        this.f21731b = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.m(this.f21731b);
    }
}
