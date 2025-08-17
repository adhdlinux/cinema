package kotlin.collections.builders;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class ListBuilderKt {
    public static final <E> E[] a(int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] b(T[] tArr, int i2) {
        Intrinsics.f(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, i2);
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final <E> void c(E[] eArr, int i2) {
        Intrinsics.f(eArr, "<this>");
        eArr[i2] = null;
    }

    public static final <E> void d(E[] eArr, int i2, int i3) {
        Intrinsics.f(eArr, "<this>");
        while (i2 < i3) {
            c(eArr, i2);
            i2++;
        }
    }
}
