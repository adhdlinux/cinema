package p;

import androidx.media3.ui.PlayerView;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerView f21905b;

    public /* synthetic */ j(PlayerView playerView) {
        this.f21905b = playerView;
    }

    public final void run() {
        this.f21905b.invalidate();
    }
}
