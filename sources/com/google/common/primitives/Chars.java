package com.google.common.primitives;

import com.google.common.base.Preconditions;

public final class Chars {
    private Chars() {
    }

    public static char a(long j2) {
        boolean z2;
        char c2 = (char) ((int) j2);
        if (((long) c2) == j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.g(z2, "Out of range: %s", j2);
        return c2;
    }

    public static boolean b(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public static char c(byte b2, byte b3) {
        return (char) ((b2 << 8) | (b3 & 255));
    }
}
