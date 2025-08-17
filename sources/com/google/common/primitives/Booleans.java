package com.google.common.primitives;

public final class Booleans {
    private Booleans() {
    }

    public static int a(boolean z2, boolean z3) {
        if (z2 == z3) {
            return 0;
        }
        return z2 ? 1 : -1;
    }

    public static boolean b(boolean[] zArr, boolean z2) {
        for (boolean z3 : zArr) {
            if (z3 == z2) {
                return true;
            }
        }
        return false;
    }
}
