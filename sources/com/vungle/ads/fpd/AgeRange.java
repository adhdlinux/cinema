package com.vungle.ads.fpd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

public enum AgeRange {
    AGE_18_20(1, new IntRange(18, 20)),
    AGE_21_30(2, new IntRange(21, 30)),
    AGE_31_40(3, new IntRange(31, 40)),
    AGE_41_50(4, new IntRange(41, 50)),
    AGE_51_60(5, new IntRange(51, 60)),
    AGE_61_70(6, new IntRange(61, 70)),
    AGE_71_75(7, new IntRange(71, 75)),
    OTHERS(0, new IntRange(Integer.MIN_VALUE, Integer.MAX_VALUE));
    
    public static final Companion Companion = null;
    private final int id;
    private final IntRange range;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AgeRange fromAge$vungle_ads_release(int i2) {
            AgeRange ageRange;
            boolean z2;
            AgeRange[] values = AgeRange.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    ageRange = null;
                    break;
                }
                ageRange = values[i3];
                IntRange range = ageRange.getRange();
                int a2 = range.a();
                if (i2 > range.b() || a2 > i2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    break;
                }
                i3++;
            }
            if (ageRange == null) {
                return AgeRange.OTHERS;
            }
            return ageRange;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private AgeRange(int i2, IntRange intRange) {
        this.id = i2;
        this.range = intRange;
    }

    public final int getId() {
        return this.id;
    }

    public final IntRange getRange() {
        return this.range;
    }
}
