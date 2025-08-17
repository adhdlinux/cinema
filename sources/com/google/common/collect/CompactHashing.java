package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;

final class CompactHashing {
    private CompactHashing() {
    }

    static Object a(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i2);
        } else if (i2 <= 256) {
            return new byte[i2];
        } else {
            if (i2 <= 65536) {
                return new short[i2];
            }
            return new int[i2];
        }
    }

    static int b(int i2, int i3) {
        return i2 & (~i3);
    }

    static int c(int i2, int i3) {
        return i2 & i3;
    }

    static int d(int i2, int i3, int i4) {
        return (i2 & (~i4)) | (i3 & i4);
    }

    static int e(int i2) {
        return (i2 < 32 ? 4 : 2) * (i2 + 1);
    }

    static int f(Object obj, Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i3;
        int i4;
        int c2 = Hashing.c(obj);
        int i5 = c2 & i2;
        int h2 = h(obj3, i5);
        if (h2 == 0) {
            return -1;
        }
        int b2 = b(c2, i2);
        int i6 = -1;
        while (true) {
            i3 = h2 - 1;
            i4 = iArr[i3];
            if (b(i4, i2) != b2 || !Objects.a(obj, objArr[i3]) || (objArr2 != null && !Objects.a(obj2, objArr2[i3]))) {
                int c3 = c(i4, i2);
                if (c3 == 0) {
                    return -1;
                }
                int i7 = c3;
                i6 = i3;
                h2 = i7;
            }
        }
        int c4 = c(i4, i2);
        if (i6 == -1) {
            i(obj3, i5, c4);
        } else {
            iArr[i6] = d(iArr[i6], c4, i2);
        }
        return i3;
    }

    static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static int h(Object obj, int i2) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i2] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i2] & 65535;
        }
        return ((int[]) obj)[i2];
    }

    static void i(Object obj, int i2, int i3) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i3;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i3;
        } else {
            ((int[]) obj)[i2] = i3;
        }
    }

    static int j(int i2) {
        return Math.max(4, Hashing.a(i2 + 1, 1.0d));
    }
}
