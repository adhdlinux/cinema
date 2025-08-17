package b1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class f0 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f29280a;

    public /* synthetic */ f0(AlertDialog alertDialog) {
        this.f29280a = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        PlayerActivity.k2(this.f29280a, dialogInterface);
    }
}
