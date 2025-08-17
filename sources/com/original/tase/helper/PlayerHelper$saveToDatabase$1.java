package com.original.tase.helper;

import androidx.appcompat.app.AppCompatActivity;
import com.utils.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$saveToDatabase$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f33858f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$saveToDatabase$1(AppCompatActivity appCompatActivity) {
        super(1);
        this.f33858f = appCompatActivity;
    }

    public final void b(String str) {
        Utils.i0(this.f33858f, str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        b((String) obj);
        return Unit.f40298a;
    }
}
