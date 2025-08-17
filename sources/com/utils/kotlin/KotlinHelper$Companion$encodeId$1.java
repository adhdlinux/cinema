package com.utils.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class KotlinHelper$Companion$encodeId$1 extends Lambda implements Function1<Character, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    public static final KotlinHelper$Companion$encodeId$1 f37694f = new KotlinHelper$Companion$encodeId$1();

    KotlinHelper$Companion$encodeId$1() {
        super(1);
    }

    public final CharSequence a(char c2) {
        String num = Integer.toString(c2, CharsKt__CharJVMKt.a(16));
        Intrinsics.e(num, "toString(this, checkRadix(radix))");
        return num;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Character) obj).charValue());
    }
}
