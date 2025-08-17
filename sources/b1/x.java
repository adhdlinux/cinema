package b1;

import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29311c;

    public /* synthetic */ x(int i2, PlayerActivity playerActivity) {
        this.f29310b = i2;
        this.f29311c = playerActivity;
    }

    public final void run() {
        PlayerActivity.u2(this.f29310b, this.f29311c);
    }
}
