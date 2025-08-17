package com.utils.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class KotlinHelper$Companion$getpassGdriverplayer$password$1 extends Lambda implements Function1<String, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    public static final KotlinHelper$Companion$getpassGdriverplayer$password$1 f37696f = new KotlinHelper$Companion$getpassGdriverplayer$password$1();

    KotlinHelper$Companion$getpassGdriverplayer$password$1() {
        super(1);
    }

    /* renamed from: b */
    public final CharSequence invoke(String str) {
        Intrinsics.f(str, "it");
        int parseInt = Integer.parseInt(str);
        if (parseInt >= 0 && parseInt <= 65535) {
            return String.valueOf((char) parseInt);
        }
        throw new IllegalArgumentException("Invalid Char code: " + parseInt);
    }
}
