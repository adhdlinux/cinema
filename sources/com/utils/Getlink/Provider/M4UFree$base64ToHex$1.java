package com.utils.Getlink.Provider;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

final class M4UFree$base64ToHex$1 extends Lambda implements Function1<Byte, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    public static final M4UFree$base64ToHex$1 f37377f = new M4UFree$base64ToHex$1();

    M4UFree$base64ToHex$1() {
        super(1);
    }

    public final CharSequence a(byte b2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).byteValue());
    }
}
