package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class c0 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29273b;

    public /* synthetic */ c0(Ref$IntRef ref$IntRef) {
        this.f29273b = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.h2(this.f29273b, dialogInterface, i2);
    }
}
