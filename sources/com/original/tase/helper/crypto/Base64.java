package com.original.tase.helper.crypto;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33883a = System.getProperty("line.separator");

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f33884b = new char[64];

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f33885c = new byte[128];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f33884b[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f33884b[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f33884b[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f33884b;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        int i3 = 0;
        while (true) {
            byte[] bArr = f33885c;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f33885c[f33884b[i4]] = (byte) i4;
        }
    }

    private Base64() {
    }

    public static byte[] a(char[] cArr, int i2, int i3) {
        int i4;
        char c2;
        char c3;
        int i5;
        if (i3 % 4 == 0) {
            while (i3 > 0 && cArr[(i2 + i3) - 1] == '=') {
                i3--;
            }
            int i6 = (i3 * 3) / 4;
            byte[] bArr = new byte[i6];
            int i7 = i3 + i2;
            int i8 = 0;
            while (i2 < i7) {
                int i9 = i2 + 1;
                char c4 = cArr[i2];
                int i10 = i9 + 1;
                char c5 = cArr[i9];
                if (i10 < i7) {
                    i4 = i10 + 1;
                    c2 = cArr[i10];
                } else {
                    i4 = i10;
                    c2 = 'A';
                }
                if (i4 < i7) {
                    i5 = i4 + 1;
                    c3 = cArr[i4];
                } else {
                    i5 = i4;
                    c3 = 'A';
                }
                if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = f33885c;
                byte b2 = bArr2[c4];
                byte b3 = bArr2[c5];
                byte b4 = bArr2[c2];
                byte b5 = bArr2[c3];
                if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i11 = (b2 << 2) | (b3 >>> 4);
                int i12 = ((b3 & 15) << 4) | (b4 >>> 2);
                byte b6 = ((b4 & 3) << 6) | b5;
                int i13 = i8 + 1;
                bArr[i8] = (byte) i11;
                if (i13 < i6) {
                    bArr[i13] = (byte) i12;
                    i13++;
                }
                if (i13 < i6) {
                    bArr[i13] = (byte) b6;
                    i8 = i13 + 1;
                } else {
                    i8 = i13;
                }
                i2 = i5;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static byte[] b(String str) {
        char[] cArr = new char[str.length()];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (!(charAt == ' ' || charAt == 13 || charAt == 10 || charAt == 9)) {
                cArr[i2] = charAt;
                i2++;
            }
        }
        return a(cArr, 0, i2);
    }

    public static char[] c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public static char[] d(byte[] bArr, int i2, int i3) {
        int i4;
        byte b2;
        byte b3;
        char c2;
        int i5 = ((i3 * 4) + 2) / 3;
        char[] cArr = new char[(((i3 + 2) / 3) * 4)];
        int i6 = i3 + i2;
        int i7 = 0;
        while (i2 < i6) {
            int i8 = i2 + 1;
            byte b4 = bArr[i2] & 255;
            if (i8 < i6) {
                i4 = i8 + 1;
                b2 = bArr[i8] & 255;
            } else {
                i4 = i8;
                b2 = 0;
            }
            if (i4 < i6) {
                int i9 = i4 + 1;
                b3 = bArr[i4] & 255;
                i4 = i9;
            } else {
                b3 = 0;
            }
            int i10 = b4 >>> 2;
            int i11 = ((b4 & 3) << 4) | (b2 >>> 4);
            int i12 = ((b2 & 15) << 2) | (b3 >>> 6);
            byte b5 = b3 & 63;
            int i13 = i7 + 1;
            char[] cArr2 = f33884b;
            cArr[i7] = cArr2[i10];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[i11];
            char c3 = '=';
            if (i14 < i5) {
                c2 = cArr2[i12];
            } else {
                c2 = '=';
            }
            cArr[i14] = c2;
            int i15 = i14 + 1;
            if (i15 < i5) {
                c3 = cArr2[b5];
            }
            cArr[i15] = c3;
            i7 = i15 + 1;
            i2 = i4;
        }
        return cArr;
    }
}
