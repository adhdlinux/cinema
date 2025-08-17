package com.original.tase.helper;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.utils.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$downloadApk$1$onFailure$1 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33853f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$downloadApk$1$onFailure$1(PlayerHelper playerHelper) {
        super(0);
        this.f33853f = playerHelper;
    }

    public final void invoke() {
        ProgressDialog t2 = this.f33853f.f33843f;
        if (t2 == null) {
            Intrinsics.x("progressDialog");
            t2 = null;
        }
        t2.dismiss();
        Toast.makeText(Utils.v(), "Download failed", 0).show();
    }
}
