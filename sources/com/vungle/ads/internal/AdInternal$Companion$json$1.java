package com.vungle.ads.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

final class AdInternal$Companion$json$1 extends Lambda implements Function1<JsonBuilder, Unit> {
    public static final AdInternal$Companion$json$1 INSTANCE = new AdInternal$Companion$json$1();

    AdInternal$Companion$json$1() {
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
    }
}
