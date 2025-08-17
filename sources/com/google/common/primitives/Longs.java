package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Arrays;

public final class Longs {

    static final class AsciiDigits {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f30727a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i2 = 0; i2 < 10; i2++) {
                bArr[i2 + 48] = (byte) i2;
            }
            for (int i3 = 0; i3 < 26; i3++) {
                byte b2 = (byte) (i3 + 10);
                bArr[i3 + 65] = b2;
                bArr[i3 + 97] = b2;
            }
            f30727a = bArr;
        }

        private AsciiDigits() {
        }

        static int a(char c2) {
            if (c2 < 128) {
                return f30727a[c2];
            }
            return -1;
        }
    }

    private Longs() {
    }

    public static int a(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static long c(long... jArr) {
        boolean z2;
        if (jArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.d(z2);
        long j2 = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public static Long d(String str, int i2) {
        String str2 = str;
        int i3 = i2;
        if (((String) Preconditions.l(str)).isEmpty()) {
            return null;
        }
        if (i3 < 2 || i3 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i3);
        }
        int i4 = 0;
        if (str2.charAt(0) == '-') {
            i4 = 1;
        }
        if (i4 == str.length()) {
            return null;
        }
        int i5 = i4 + 1;
        int a2 = AsciiDigits.a(str2.charAt(i4));
        if (a2 < 0 || a2 >= i3) {
            return null;
        }
        long j2 = (long) (-a2);
        long j3 = (long) i3;
        long j4 = Long.MIN_VALUE / j3;
        while (i5 < str.length()) {
            int i6 = i5 + 1;
            int a3 = AsciiDigits.a(str2.charAt(i5));
            if (a3 < 0 || a3 >= i3 || j2 < j4) {
                return null;
            }
            long j5 = j2 * j3;
            long j6 = (long) a3;
            if (j5 < j6 - Long.MIN_VALUE) {
                return null;
            }
            j2 = j5 - j6;
            i5 = i6;
        }
        if (i4 != 0) {
            return Long.valueOf(j2);
        }
        if (j2 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j2);
    }
}
