package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class i0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29287c;

    public /* synthetic */ i0(PlayerActivity playerActivity, Ref$IntRef ref$IntRef) {
        this.f29286b = playerActivity;
        this.f29287c = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.Y1(this.f29286b, this.f29287c, dialogInterface, i2);
    }
}
