package com.original.tase.helper;

import androidx.appcompat.app.AppCompatActivity;
import com.utils.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PlayerHelper$saveToDatabase$4 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f33861f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerHelper$saveToDatabase$4(AppCompatActivity appCompatActivity) {
        super(1);
        this.f33861f = appCompatActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        Utils.i0(this.f33861f, th.getMessage());
    }
}
