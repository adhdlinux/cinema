package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class e0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29278b;

    public /* synthetic */ e0(PlayerActivity playerActivity) {
        this.f29278b = playerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.j2(this.f29278b, dialogInterface, i2);
    }
}
