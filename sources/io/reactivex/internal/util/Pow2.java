package io.reactivex.internal.util;

public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static int a(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
