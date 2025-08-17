package com.google.common.math;

import com.google.common.base.Preconditions;

final class DoubleUtils {
    private DoubleUtils() {
    }

    static long a(double d2) {
        Preconditions.e(b(d2), "not a normal value");
        int exponent = Math.getExponent(d2);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
        if (exponent == -1023) {
            return doubleToRawLongBits << 1;
        }
        return doubleToRawLongBits | 4503599627370496L;
    }

    static boolean b(double d2) {
        return Math.getExponent(d2) <= 1023;
    }
}
