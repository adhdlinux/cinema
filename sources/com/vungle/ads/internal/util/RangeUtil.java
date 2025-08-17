package com.vungle.ads.internal.util;

public final class RangeUtil {
    public static final RangeUtil INSTANCE = new RangeUtil();

    private RangeUtil() {
    }

    public static /* synthetic */ boolean isInRange$default(RangeUtil rangeUtil, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return rangeUtil.isInRange(i2, i3, i4);
    }

    public final boolean isInRange(float f2, float f3, float f4) {
        return f3 <= f2 && f2 <= f4;
    }

    public final boolean isInRange(int i2, int i3, int i4) {
        return i3 <= i2 && i2 <= i4;
    }

    public static /* synthetic */ boolean isInRange$default(RangeUtil rangeUtil, float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f4 = Float.MAX_VALUE;
        }
        return rangeUtil.isInRange(f2, f3, f4);
    }
}
