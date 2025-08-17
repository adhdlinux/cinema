package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TsUtil {
    private TsUtil() {
    }

    public static int a(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static boolean b(byte[] bArr, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = -4; i6 <= 4; i6++) {
            int i7 = (i6 * 188) + i4;
            if (i7 < i2 || i7 >= i3 || bArr[i7] != 71) {
                i5 = 0;
            } else {
                i5++;
                if (i5 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(ParsableByteArray parsableByteArray, int i2, int i3) {
        boolean z2;
        parsableByteArray.U(i2);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        int q2 = parsableByteArray.q();
        if ((8388608 & q2) != 0 || ((2096896 & q2) >> 8) != i3) {
            return -9223372036854775807L;
        }
        boolean z3 = true;
        if ((q2 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && parsableByteArray.H() >= 7 && parsableByteArray.a() >= 7) {
            if ((parsableByteArray.H() & 16) != 16) {
                z3 = false;
            }
            if (z3) {
                byte[] bArr = new byte[6];
                parsableByteArray.l(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
