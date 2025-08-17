package com.original.tase.helper;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.utils.Utils;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$downloadApk$1$onResponse$1$3 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33856f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ File f33857g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$downloadApk$1$onResponse$1$3(PlayerHelper playerHelper, File file) {
        super(0);
        this.f33856f = playerHelper;
        this.f33857g = file;
    }

    public final void invoke() {
        ProgressDialog t2 = this.f33856f.f33843f;
        if (t2 == null) {
            Intrinsics.x("progressDialog");
            t2 = null;
        }
        t2.dismiss();
        Toast.makeText(Utils.v(), "Download complete", 0).show();
        this.f33856f.y(this.f33857g);
    }
}
