package q1;

import kotlin.text.c;

public final /* synthetic */ class i {
    public static /* synthetic */ String a(long j2, int i2) {
        int i3 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j2, i2);
        }
        if (i2 < 2 || i2 > 36) {
            i2 = 10;
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i2 - 1;
        if ((i2 & i5) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j2) & i5, i2);
                j2 >>>= numberOfTrailingZeros;
            } while (j2 != 0);
        } else {
            long a2 = (i2 & 1) == 0 ? (j2 >>> 1) / ((long) (i2 >>> 1)) : c.a(j2, (long) i2);
            long j3 = (long) i2;
            cArr[63] = Character.forDigit((int) (j2 - (a2 * j3)), i2);
            i4 = 63;
            while (a2 > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (a2 % j3), i2);
                a2 /= j3;
            }
        }
        return new String(cArr, i4, 64 - i4);
    }
}
