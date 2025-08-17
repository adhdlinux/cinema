package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static int b(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static long c(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static int d(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static long e(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static int f(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static long g(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    public static IntProgression h(int i2, int i3) {
        return IntProgression.f40455e.a(i2, i3, -1);
    }

    public static IntProgression i(IntProgression intProgression, int i2) {
        boolean z2;
        Intrinsics.f(intProgression, "<this>");
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        RangesKt__RangesKt.a(z2, Integer.valueOf(i2));
        IntProgression.Companion companion = IntProgression.f40455e;
        int a2 = intProgression.a();
        int b2 = intProgression.b();
        if (intProgression.d() <= 0) {
            i2 = -i2;
        }
        return companion.a(a2, b2, i2);
    }

    public static IntRange j(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return IntRange.f40463f.a();
        }
        return new IntRange(i2, i3 - 1);
    }
}
