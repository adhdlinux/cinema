package com.chartboost.sdk.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static final w1 f18884a = new w1();

    public final String a(byte[] bArr) {
        String format = String.format("%0" + (bArr.length << 1) + 'x', Arrays.copyOf(new Object[]{new BigInteger(1, bArr)}, 1));
        Intrinsics.e(format, "format(this, *args)");
        return format;
    }

    public final byte[] b(byte[] bArr) {
        return MessageDigest.getInstance("SHA-1").digest(bArr);
    }

    public static final String a(String str) {
        Intrinsics.f(str, "input");
        byte[] bytes = str.getBytes(Charsets.f40513b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        w1 w1Var = f18884a;
        return w1Var.a(w1Var.b(bytes));
    }
}
