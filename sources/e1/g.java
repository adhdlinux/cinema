package e1;

import android.content.DialogInterface;
import com.original.tase.helper.PlayerHelper;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class g implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f38182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38183c;

    public /* synthetic */ g(Ref$IntRef ref$IntRef, PlayerHelper playerHelper) {
        this.f38182b = ref$IntRef;
        this.f38183c = playerHelper;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerHelper.f0(this.f38182b, this.f38183c, dialogInterface, i2);
    }
}
