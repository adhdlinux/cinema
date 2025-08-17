package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class j0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29289b;

    public /* synthetic */ j0(PlayerActivity playerActivity) {
        this.f29289b = playerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.Z1(this.f29289b, dialogInterface, i2);
    }
}
