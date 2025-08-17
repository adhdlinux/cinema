package kotlin.time;

import kotlin.jvm.internal.Intrinsics;

class DurationUnitKt__DurationUnitJvmKt {
    public static final double a(double d2, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.f(durationUnit, "sourceUnit");
        Intrinsics.f(durationUnit2, "targetUnit");
        long convert = durationUnit2.b().convert(1, durationUnit.b());
        if (convert > 0) {
            return d2 * ((double) convert);
        }
        return d2 / ((double) durationUnit.b().convert(1, durationUnit2.b()));
    }

    public static final long b(long j2, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.f(durationUnit, "sourceUnit");
        Intrinsics.f(durationUnit2, "targetUnit");
        return durationUnit2.b().convert(j2, durationUnit.b());
    }

    public static final long c(long j2, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.f(durationUnit, "sourceUnit");
        Intrinsics.f(durationUnit2, "targetUnit");
        return durationUnit2.b().convert(j2, durationUnit.b());
    }
}
