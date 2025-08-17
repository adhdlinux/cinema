package com.original.tase.helper;

import androidx.appcompat.app.AppCompatActivity;
import com.utils.Utils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$saveToDatabase$5$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33863f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$saveToDatabase$5$2(PlayerHelper playerHelper) {
        super(1);
        this.f33863f = playerHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        Intrinsics.f(th, "throwable");
        WeakReference s2 = this.f33863f.f33845h;
        Utils.i0(s2 != null ? (AppCompatActivity) s2.get() : null, th.getMessage());
    }
}
