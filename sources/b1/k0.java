package b1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class k0 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f29291a;

    public /* synthetic */ k0(AlertDialog alertDialog) {
        this.f29291a = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        PlayerActivity.a2(this.f29291a, dialogInterface);
    }
}
