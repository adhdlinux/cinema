package b1;

import android.view.MotionEvent;
import android.view.View;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class g implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29281b;

    public /* synthetic */ g(PlayerActivity playerActivity) {
        this.f29281b = playerActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return PlayerActivity.H1(this.f29281b, view, motionEvent);
    }
}
