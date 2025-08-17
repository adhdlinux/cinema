package com.vungle.ads.fpd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

public enum MedianHomeValueUSD {
    UNDER_100K(0, new IntRange(Integer.MIN_VALUE, 100000)),
    FROM_100K_TO_300K(1, new IntRange(100001, 300000)),
    FROM_300K_TO_500K(2, new IntRange(300001, 500000)),
    FROM_500K_TO_700K(3, new IntRange(500001, 700000)),
    FROM_700K_TO_900K(4, new IntRange(700001, 900000)),
    FROM_900K_TO_1M1(5, new IntRange(900001, 1100000)),
    FROM_1M1_TO_1M3(6, new IntRange(1100001, 1300000)),
    FROM_1M3_TO_1M5(7, new IntRange(1300001, 1500000)),
    FROM_1M5_TO_1M7(8, new IntRange(1500001, 1700000)),
    OVER_1M7(9, new IntRange(1700001, Integer.MAX_VALUE));
    
    public static final Companion Companion = null;
    private final int id;
    private final IntRange range;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MedianHomeValueUSD fromPrice$vungle_ads_release(int i2) {
            MedianHomeValueUSD medianHomeValueUSD;
            boolean z2;
            MedianHomeValueUSD[] values = MedianHomeValueUSD.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    medianHomeValueUSD = null;
                    break;
                }
                medianHomeValueUSD = values[i3];
                IntRange range = medianHomeValueUSD.getRange();
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
            if (medianHomeValueUSD == null) {
                return MedianHomeValueUSD.UNDER_100K;
            }
            return medianHomeValueUSD;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private MedianHomeValueUSD(int i2, IntRange intRange) {
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
