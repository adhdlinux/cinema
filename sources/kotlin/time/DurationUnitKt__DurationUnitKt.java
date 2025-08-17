package kotlin.time;

import kotlin.jvm.internal.Intrinsics;

class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    public static final DurationUnit d(char c2, boolean z2) {
        if (!z2) {
            if (c2 == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c2);
        } else if (c2 == 'H') {
            return DurationUnit.HOURS;
        } else {
            if (c2 == 'M') {
                return DurationUnit.MINUTES;
            }
            if (c2 == 'S') {
                return DurationUnit.SECONDS;
            }
            throw new IllegalArgumentException("Invalid duration ISO time unit: " + c2);
        }
    }

    public static final DurationUnit e(String str) {
        Intrinsics.f(str, "shortName");
        int hashCode = str.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && str.equals("us")) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (str.equals("ns")) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (str.equals("ms")) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (str.equals("s")) {
                        return DurationUnit.SECONDS;
                    }
                } else if (str.equals("m")) {
                    return DurationUnit.MINUTES;
                }
            } else if (str.equals("h")) {
                return DurationUnit.HOURS;
            }
        } else if (str.equals("d")) {
            return DurationUnit.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + str);
    }
}
