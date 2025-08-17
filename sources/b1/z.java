package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class z implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29314c;

    public /* synthetic */ z(PlayerActivity playerActivity, Ref$IntRef ref$IntRef) {
        this.f29313b = playerActivity;
        this.f29314c = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.R1(this.f29313b, this.f29314c, dialogInterface, i2);
    }
}
