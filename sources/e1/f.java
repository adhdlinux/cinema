package e1;

import android.content.DialogInterface;
import com.original.tase.helper.PlayerHelper;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f38181b;

    public /* synthetic */ f(Ref$IntRef ref$IntRef) {
        this.f38181b = ref$IntRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerHelper.e0(this.f38181b, dialogInterface, i2);
    }
}
