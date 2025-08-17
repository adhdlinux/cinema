package com.facebook.common.util;

import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

@Nullsafe(Nullsafe.Mode.STRICT)
public class Hex {
    private static final byte[] DIGITS = new byte[103];
    private static final char[] FIRST_CHAR = new char[UserVerificationMethods.USER_VERIFY_HANDPRINT];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] SECOND_CHAR = new char[UserVerificationMethods.USER_VERIFY_HANDPRINT];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(i2 >> 4) & 15];
            SECOND_CHAR[i2] = cArr2[i2 & 15];
        }
        for (int i3 = 0; i3 <= 70; i3++) {
            DIGITS[i3] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            DIGITS[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = DIGITS;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String byte2Hex(int i2) {
        if (i2 > 255 || i2 < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return String.valueOf(FIRST_CHAR[i2]) + String.valueOf(SECOND_CHAR[i2]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r8 = DIGITS;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decodeHex(java.lang.String r11) {
        /*
            int r0 = r11.length()
            r1 = r0 & 1
            if (r1 != 0) goto L_0x0057
            int r1 = r0 >> 1
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000f:
            if (r3 >= r0) goto L_0x003d
            int r5 = r3 + 1
            char r3 = r11.charAt(r3)
            r6 = 102(0x66, float:1.43E-43)
            r7 = 1
            if (r3 <= r6) goto L_0x001e
        L_0x001c:
            r2 = 1
            goto L_0x003d
        L_0x001e:
            byte[] r8 = DIGITS
            byte r3 = r8[r3]
            r9 = -1
            if (r3 != r9) goto L_0x0026
            goto L_0x001c
        L_0x0026:
            int r10 = r5 + 1
            char r5 = r11.charAt(r5)
            if (r5 <= r6) goto L_0x002f
            goto L_0x001c
        L_0x002f:
            byte r5 = r8[r5]
            if (r5 != r9) goto L_0x0034
            goto L_0x001c
        L_0x0034:
            int r3 = r3 << 4
            r3 = r3 | r5
            byte r3 = (byte) r3
            r1[r4] = r3
            int r4 = r4 + r7
            r3 = r10
            goto L_0x000f
        L_0x003d:
            if (r2 != 0) goto L_0x0040
            return r1
        L_0x0040:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid hexadecimal digit: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        L_0x0057:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Odd number of characters."
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.util.Hex.decodeHex(java.lang.String):byte[]");
    }

    public static String encodeHex(byte[] bArr, boolean z2) {
        byte b2;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && ((b2 = bArr[i2] & 255) != 0 || !z2)) {
            int i4 = i3 + 1;
            cArr[i3] = FIRST_CHAR[b2];
            i3 = i4 + 1;
            cArr[i4] = SECOND_CHAR[b2];
            i2++;
        }
        return new String(cArr, 0, i3);
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(" ", ""));
    }
}
