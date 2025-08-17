package com.vungle.ads.fpd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

public enum LengthOfResidence {
    LESS_THAN_ONE_YEAR(0, new IntRange(Integer.MIN_VALUE, 0)),
    ONE_TO_FIVE_YEARS(1, new IntRange(1, 5)),
    SIX_TO_TEN_YEARS(2, new IntRange(6, 10)),
    ELEVEN_TO_TWENTY_YEARS(3, new IntRange(11, 20)),
    TWENTY_ONE_TO_THIRTY_YEARS(4, new IntRange(21, 30)),
    THIRTY_ONE_TO_FORTY_YEARS(5, new IntRange(31, 40)),
    FORTY_ONE_TO_FIFTY_YEARS(6, new IntRange(41, 50)),
    FIFTY_ONE_TO_SIXTY_YEARS(7, new IntRange(51, 60)),
    SIXTY_ONE_TO_SEVENTY_YEARS(8, new IntRange(61, 70)),
    OVER_SEVENTY_ONE_YEARS(9, new IntRange(71, Integer.MAX_VALUE));
    
    public static final Companion Companion = null;
    private final int id;
    private final IntRange range;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LengthOfResidence fromYears$vungle_ads_release(int i2) {
            LengthOfResidence lengthOfResidence;
            boolean z2;
            LengthOfResidence[] values = LengthOfResidence.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    lengthOfResidence = null;
                    break;
                }
                lengthOfResidence = values[i3];
                IntRange range = lengthOfResidence.getRange();
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
            if (lengthOfResidence == null) {
                return LengthOfResidence.LESS_THAN_ONE_YEAR;
            }
            return lengthOfResidence;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private LengthOfResidence(int i2, IntRange intRange) {
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
