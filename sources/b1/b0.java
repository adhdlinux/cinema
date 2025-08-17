package b1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class b0 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f29271a;

    public /* synthetic */ b0(AlertDialog alertDialog) {
        this.f29271a = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        PlayerActivity.T1(this.f29271a, dialogInterface);
    }
}
