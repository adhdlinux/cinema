package com.google.android.exoplayer2.util;

public final class RepeatModeUtil {
    private RepeatModeUtil() {
    }

    public static int a(int i2, int i3) {
        for (int i4 = 1; i4 <= 2; i4++) {
            int i5 = (i2 + i4) % 3;
            if (b(i5, i3)) {
                return i5;
            }
        }
        return i2;
    }

    public static boolean b(int i2, int i3) {
        if (i2 != 0) {
            return i2 != 1 ? i2 == 2 && (i3 & 2) != 0 : (i3 & 1) != 0;
        }
        return true;
    }
}
