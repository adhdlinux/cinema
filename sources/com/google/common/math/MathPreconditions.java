package com.google.common.math;

import java.math.RoundingMode;

final class MathPreconditions {
    private MathPreconditions() {
    }

    static void a(boolean z2, double d2, RoundingMode roundingMode) {
        if (!z2) {
            throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
        }
    }

    static void b(boolean z2, String str, int i2, int i3) {
        if (!z2) {
            throw new ArithmeticException("overflow: " + str + "(" + i2 + ", " + i3 + ")");
        }
    }

    static void c(boolean z2, String str, long j2, long j3) {
        if (!z2) {
            throw new ArithmeticException("overflow: " + str + "(" + j2 + ", " + j3 + ")");
        }
    }

    static long d(String str, long j2) {
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " (" + j2 + ") must be >= 0");
    }

    static void e(boolean z2) {
        if (!z2) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
