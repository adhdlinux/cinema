package com.google.zxing.qrcode.encoder;

final class MaskUtil {
    private MaskUtil() {
    }

    static int a(ByteMatrix byteMatrix) {
        return b(byteMatrix, true) + b(byteMatrix, false);
    }

    private static int b(ByteMatrix byteMatrix, boolean z2) {
        int i2;
        int i3;
        byte b2;
        if (z2) {
            i2 = byteMatrix.d();
        } else {
            i2 = byteMatrix.e();
        }
        if (z2) {
            i3 = byteMatrix.e();
        } else {
            i3 = byteMatrix.d();
        }
        byte[][] c2 = byteMatrix.c();
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b3 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                if (z2) {
                    b2 = c2[i5][i7];
                } else {
                    b2 = c2[i7][i5];
                }
                if (b2 == b3) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    b3 = b2;
                    i6 = 1;
                }
            }
            if (i6 >= 5) {
                i4 += (i6 - 5) + 3;
            }
        }
        return i4;
    }

    static int c(ByteMatrix byteMatrix) {
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2 - 1; i3++) {
            int i4 = 0;
            while (i4 < e2 - 1) {
                byte[] bArr = c2[i3];
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    byte[] bArr2 = c2[i3 + 1];
                    if (b2 == bArr2[i4] && b2 == bArr2[i5]) {
                        i2++;
                    }
                }
                i4 = i5;
            }
        }
        return i2 * 3;
    }

    static int d(ByteMatrix byteMatrix) {
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            for (int i4 = 0; i4 < e2; i4++) {
                byte[] bArr = c2[i3];
                int i5 = i4 + 6;
                if (i5 < e2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (g(bArr, i4 - 4, i4) || g(bArr, i4 + 7, i4 + 11))) {
                    i2++;
                }
                int i6 = i3 + 6;
                if (i6 < d2 && c2[i3][i4] == 1 && c2[i3 + 1][i4] == 0 && c2[i3 + 2][i4] == 1 && c2[i3 + 3][i4] == 1 && c2[i3 + 4][i4] == 1 && c2[i3 + 5][i4] == 0 && c2[i6][i4] == 1 && (h(c2, i4, i3 - 4, i3) || h(c2, i4, i3 + 7, i3 + 11))) {
                    i2++;
                }
            }
        }
        return i2 * 40;
    }

    static int e(ByteMatrix byteMatrix) {
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte[] bArr = c2[i3];
            for (int i4 = 0; i4 < e2; i4++) {
                if (bArr[i4] == 1) {
                    i2++;
                }
            }
        }
        int d3 = byteMatrix.d() * byteMatrix.e();
        return ((Math.abs((i2 * 2) - d3) * 10) / d3) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1 != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x0041;
                case 1: goto L_0x0042;
                case 2: goto L_0x003e;
                case 3: goto L_0x003a;
                case 4: goto L_0x0035;
                case 5: goto L_0x002d;
                case 6: goto L_0x0024;
                case 7: goto L_0x001b;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x001b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x002b
        L_0x0024:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x002b:
            r1 = r1 & r0
            goto L_0x0044
        L_0x002d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x0044
        L_0x0035:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x0041
        L_0x003a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x0044
        L_0x003e:
            int r1 = r2 % 3
            goto L_0x0044
        L_0x0041:
            int r3 = r3 + r2
        L_0x0042:
            r1 = r3 & 1
        L_0x0044:
            if (r1 != 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (i3 >= 0 && i3 < bArr.length && bArr[i3][i2] == 1) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
