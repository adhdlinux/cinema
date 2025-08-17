package kotlin;

import kotlin.jvm.internal.Intrinsics;

public final class UnsignedKt {
    public static final int a(int i2, int i3) {
        return Intrinsics.h(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j2, long j3) {
        return Intrinsics.i(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
    }

    public static final String c(long j2) {
        return d(j2, 10);
    }

    public static final String d(long j2, int i2) {
        if (j2 >= 0) {
            String l2 = Long.toString(j2, CharsKt__CharJVMKt.a(i2));
            Intrinsics.e(l2, "toString(this, checkRadix(radix))");
            return l2;
        }
        long j3 = (long) i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        String l3 = Long.toString(j4, CharsKt__CharJVMKt.a(i2));
        Intrinsics.e(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        String l4 = Long.toString(j5, CharsKt__CharJVMKt.a(i2));
        Intrinsics.e(l4, "toString(this, checkRadix(radix))");
        sb.append(l4);
        return sb.toString();
    }
}
