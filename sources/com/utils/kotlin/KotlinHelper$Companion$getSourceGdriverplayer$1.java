package com.utils.kotlin;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;

final class KotlinHelper$Companion$getSourceGdriverplayer$1 extends Lambda implements Function1<MatchResult, Pair<? extends String, ? extends String>> {

    /* renamed from: f  reason: collision with root package name */
    public static final KotlinHelper$Companion$getSourceGdriverplayer$1 f37695f = new KotlinHelper$Companion$getSourceGdriverplayer$1();

    KotlinHelper$Companion$getSourceGdriverplayer$1() {
        super(1);
    }

    /* renamed from: b */
    public final Pair<String, String> invoke(MatchResult matchResult) {
        Intrinsics.f(matchResult, "it");
        return TuplesKt.a(StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(matchResult.a().get(1), "&t=", "", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), matchResult.a().get(2));
    }
}
