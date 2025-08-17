package b1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class g0 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f29282a;

    public /* synthetic */ g0(AlertDialog alertDialog) {
        this.f29282a = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        PlayerActivity.f2(this.f29282a, dialogInterface);
    }
}
