package com.movie.ui.activity.player.text;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CustomDecoder$getStr$3 extends Lambda implements Function1<String, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ StringBuilder f32468f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomDecoder$getStr$3(StringBuilder sb) {
        super(1);
        this.f32468f = sb;
    }

    public final void b(String str) {
        Intrinsics.f(str, "line");
        StringBuilder sb = this.f32468f;
        sb.append(str);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        b((String) obj);
        return Unit.f40298a;
    }
}
