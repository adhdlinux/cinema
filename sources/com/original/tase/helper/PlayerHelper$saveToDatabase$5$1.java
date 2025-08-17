package com.original.tase.helper;

import androidx.appcompat.app.AppCompatActivity;
import com.utils.Utils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$saveToDatabase$5$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33862f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$saveToDatabase$5$1(PlayerHelper playerHelper) {
        super(1);
        this.f33862f = playerHelper;
    }

    public final void b(String str) {
        WeakReference s2 = this.f33862f.f33845h;
        Utils.i0(s2 != null ? (AppCompatActivity) s2.get() : null, str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        b((String) obj);
        return Unit.f40298a;
    }
}
