package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class a0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29269b;

    public /* synthetic */ a0(PlayerActivity playerActivity) {
        this.f29269b = playerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.S1(this.f29269b, dialogInterface, i2);
    }
}
