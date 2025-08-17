package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class w implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29309b;

    public /* synthetic */ w(PlayerActivity playerActivity) {
        this.f29309b = playerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.e2(this.f29309b, dialogInterface, i2);
    }
}
