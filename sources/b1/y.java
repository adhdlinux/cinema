package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class y implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f29312b;

    public /* synthetic */ y(Ref$IntRef ref$IntRef) {
        this.f29312b = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.Q1(this.f29312b, dialogInterface, i2);
    }
}
