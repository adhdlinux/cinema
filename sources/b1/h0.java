package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class h0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29284b;

    public /* synthetic */ h0(Ref$IntRef ref$IntRef) {
        this.f29284b = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.X1(this.f29284b, dialogInterface, i2);
    }
}
