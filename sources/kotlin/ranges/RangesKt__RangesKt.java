package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;

class RangesKt__RangesKt {
    public static final void a(boolean z2, Number number) {
        Intrinsics.f(number, "step");
        if (!z2) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }
}
