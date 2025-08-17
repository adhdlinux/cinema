package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class m0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f29296b;

    public /* synthetic */ m0(Function0 function0) {
        this.f29296b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.V1(this.f29296b, dialogInterface, i2);
    }
}
