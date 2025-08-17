package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class MemoryChunkUtil {
    static int adjustByteCount(int i2, int i3, int i4) {
        return Math.min(Math.max(0, i4 - i2), i3);
    }

    static void checkBounds(int i2, int i3, int i4, int i5, int i6) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        if (i5 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z4));
        if (i2 + i5 <= i6) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z5));
        if (i4 + i5 > i3) {
            z6 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z6));
    }
}
