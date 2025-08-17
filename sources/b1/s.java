package b1;

import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29303c;

    public /* synthetic */ s(PlayerActivity playerActivity, int i2) {
        this.f29302b = playerActivity;
        this.f29303c = i2;
    }

    public final void run() {
        PlayerActivity.w0(this.f29302b, this.f29303c);
    }
}
