package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class d0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29275b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29276c;

    public /* synthetic */ d0(Ref$IntRef ref$IntRef, PlayerActivity playerActivity) {
        this.f29275b = ref$IntRef;
        this.f29276c = playerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.i2(this.f29275b, this.f29276c, dialogInterface, i2);
    }
}
