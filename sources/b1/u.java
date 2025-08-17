package b1;

import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29304b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f29305c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f29306d;

    public /* synthetic */ u(PlayerActivity playerActivity, String str, Integer num) {
        this.f29304b = playerActivity;
        this.f29305c = str;
        this.f29306d = num;
    }

    public final void run() {
        PlayerActivity.m2(this.f29304b, this.f29305c, this.f29306d);
    }
}
