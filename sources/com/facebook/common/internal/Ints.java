package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class Ints {
    private Ints() {
    }

    public static int max(int... iArr) {
        boolean z2;
        if (iArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i2 = i4;
            }
        }
        return i2;
    }
}
