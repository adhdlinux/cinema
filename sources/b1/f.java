package b1;

import android.view.MotionEvent;
import android.view.View;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class f implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29279b;

    public /* synthetic */ f(PlayerActivity playerActivity) {
        this.f29279b = playerActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return PlayerActivity.G1(this.f29279b, view, motionEvent);
    }
}
