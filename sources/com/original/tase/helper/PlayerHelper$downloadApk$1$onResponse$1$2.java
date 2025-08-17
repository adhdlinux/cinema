package com.original.tase.helper;

import android.app.ProgressDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$downloadApk$1$onResponse$1$2 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33854f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ int f33855g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$downloadApk$1$onResponse$1$2(PlayerHelper playerHelper, int i2) {
        super(0);
        this.f33854f = playerHelper;
        this.f33855g = i2;
    }

    public final void invoke() {
        ProgressDialog t2 = this.f33854f.f33843f;
        if (t2 == null) {
            Intrinsics.x("progressDialog");
            t2 = null;
        }
        t2.setProgress(this.f33855g);
    }
}
