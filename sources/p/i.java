package p;

import android.graphics.Bitmap;
import androidx.media3.ui.PlayerView;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerView f21903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f21904c;

    public /* synthetic */ i(PlayerView playerView, Bitmap bitmap) {
        this.f21903b = playerView;
        this.f21904c = bitmap;
    }

    public final void run() {
        this.f21903b.O(this.f21904c);
    }
}
