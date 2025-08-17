package com.vungle.ads.fpd;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

public enum MonthlyHousingCosts {
    UNDER_500(0, new IntRange(Integer.MIN_VALUE, 500)),
    FROM_500_TO_1000(1, new IntRange(501, 1000)),
    FROM_1000_TO_1500(2, new IntRange(1001, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED)),
    FROM_1500_TO_2000(3, new IntRange(1501, 2000)),
    FROM_2000_TO_2500(4, new IntRange(2001, 2500)),
    FROM_2500_TO_3000(5, new IntRange(2501, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS)),
    FROM_3000_TO_3500(6, new IntRange(3001, 3500)),
    FROM_3500_TO_4000(7, new IntRange(3501, 4000)),
    FROM_4000_TO_4500(8, new IntRange(4001, 4500)),
    OVER_4500(9, new IntRange(4501, Integer.MAX_VALUE));
    
    public static final Companion Companion = null;
    private final int id;
    private final IntRange range;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MonthlyHousingCosts fromCost$vungle_ads_release(int i2) {
            MonthlyHousingCosts monthlyHousingCosts;
            boolean z2;
            MonthlyHousingCosts[] values = MonthlyHousingCosts.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    monthlyHousingCosts = null;
                    break;
                }
                monthlyHousingCosts = values[i3];
                IntRange range = monthlyHousingCosts.getRange();
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
            if (monthlyHousingCosts == null) {
                return MonthlyHousingCosts.UNDER_500;
            }
            return monthlyHousingCosts;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private MonthlyHousingCosts(int i2, IntRange intRange) {
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
