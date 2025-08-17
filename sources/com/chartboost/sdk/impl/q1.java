package com.chartboost.sdk.impl;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public final class q1 {
    public final String a(String str) {
        int i2;
        boolean z2;
        String C = StringsKt__StringsJVMKt.C(str, ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "", false, 4, (Object) null);
        int length = C.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            if (!z3) {
                i2 = i3;
            } else {
                i2 = length;
            }
            if (Intrinsics.h(C.charAt(i2), 32) <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z3) {
                if (!z2) {
                    z3 = true;
                } else {
                    i3++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        return C.subSequence(i3, length + 1).toString();
    }

    public final String b(String str) {
        Intrinsics.f(str, "encodedString");
        try {
            byte[] decode = Base64.decode(a(str), 2);
            Intrinsics.e(decode, "decode(encodedString.clean(), NO_WRAP)");
            return new String(decode, Charsets.f40513b);
        } catch (Exception e2) {
            String a2 = r1.f18507a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Cannot decode base64 string " + e2);
            return "";
        }
    }

    public final String c(String str) {
        Intrinsics.f(str, "originalString");
        try {
            byte[] bytes = str.getBytes(Charsets.f40513b);
            Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.e(encodeToString, "encodeToString(originalS…g.toByteArray(), NO_WRAP)");
            return a(encodeToString);
        } catch (Exception e2) {
            String a2 = r1.f18507a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Cannot encode to base64 string " + e2);
            return "";
        }
    }
}
