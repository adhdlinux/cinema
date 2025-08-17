package com.google.common.primitives;

import com.google.common.base.Preconditions;

public final class UnsignedBytes {
    private UnsignedBytes() {
    }

    public static byte a(long j2) {
        boolean z2;
        if ((j2 >> 8) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.g(z2, "out of range: %s", j2);
        return (byte) ((int) j2);
    }

    public static int b(byte b2) {
        return b2 & 255;
    }
}
