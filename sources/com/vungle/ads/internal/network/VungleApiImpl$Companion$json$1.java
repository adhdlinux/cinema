package com.vungle.ads.internal.network;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

final class VungleApiImpl$Companion$json$1 extends Lambda implements Function1<JsonBuilder, Unit> {
    public static final VungleApiImpl$Companion$json$1 INSTANCE = new VungleApiImpl$Companion$json$1();

    VungleApiImpl$Companion$json$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonBuilder) obj);
        return Unit.f40298a;
    }

    public final void invoke(JsonBuilder jsonBuilder) {
        Intrinsics.f(jsonBuilder, "$this$Json");
        jsonBuilder.f(true);
        jsonBuilder.d(true);
        jsonBuilder.e(false);
        jsonBuilder.c(true);
    }
}
