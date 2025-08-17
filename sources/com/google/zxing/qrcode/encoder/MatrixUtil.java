package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.vungle.ads.internal.protos.Sdk$SDKError;

final class MatrixUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f31271a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f31272b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f31273c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, -1}, new int[]{6, 30, 56, 82, 108, Sdk$SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, -1}, new int[]{6, 34, 60, 86, 112, Sdk$SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 158}, new int[]{6, 32, 58, 84, 110, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 162}, new int[]{6, 26, 54, 82, 110, Sdk$SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f31274d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    static void a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i2, ByteMatrix byteMatrix) throws WriterException {
        c(byteMatrix);
        d(version, byteMatrix);
        l(errorCorrectionLevel, i2, byteMatrix);
        s(version, byteMatrix);
        f(bitArray, i2, byteMatrix);
    }

    static int b(int i2, int i3) {
        if (i3 != 0) {
            int n2 = n(i3);
            int i4 = i2 << (n2 - 1);
            while (n(i4) >= n2) {
                i4 ^= i3 << (n(i4) - n2);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void c(ByteMatrix byteMatrix) {
        byteMatrix.a((byte) -1);
    }

    static void d(Version version, ByteMatrix byteMatrix) throws WriterException {
        j(byteMatrix);
        e(byteMatrix);
        r(version, byteMatrix);
        k(byteMatrix);
    }

    private static void e(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.b(8, byteMatrix.d() - 8) != 0) {
            byteMatrix.f(8, byteMatrix.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    static void f(BitArray bitArray, int i2, ByteMatrix byteMatrix) throws WriterException {
        boolean z2;
        int e2 = byteMatrix.e() - 1;
        int d2 = byteMatrix.d() - 1;
        int i3 = 0;
        int i4 = -1;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < byteMatrix.d()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = e2 - i5;
                    if (o(byteMatrix.b(i6, d2))) {
                        if (i3 < bitArray.g()) {
                            z2 = bitArray.f(i3);
                            i3++;
                        } else {
                            z2 = false;
                        }
                        if (i2 != -1 && MaskUtil.f(i2, i6, d2)) {
                            z2 = !z2;
                        }
                        byteMatrix.g(i6, d2, z2);
                    }
                }
                d2 += i4;
            }
            i4 = -i4;
            d2 += i4;
            e2 -= 2;
        }
        if (i3 != bitArray.g()) {
            throw new WriterException("Not all bits consumed: " + i3 + '/' + bitArray.g());
        }
    }

    private static void g(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int i4 = 0;
        while (i4 < 8) {
            int i5 = i2 + i4;
            if (o(byteMatrix.b(i5, i3))) {
                byteMatrix.f(i5, i3, 0);
                i4++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void h(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 5; i4++) {
            for (int i5 = 0; i5 < 5; i5++) {
                byteMatrix.f(i2 + i5, i3 + i4, f31272b[i4][i5]);
            }
        }
    }

    private static void i(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                byteMatrix.f(i2 + i5, i3 + i4, f31271a[i4][i5]);
            }
        }
    }

    private static void j(ByteMatrix byteMatrix) throws WriterException {
        int length = f31271a[0].length;
        i(0, 0, byteMatrix);
        i(byteMatrix.e() - length, 0, byteMatrix);
        i(0, byteMatrix.e() - length, byteMatrix);
        g(0, 7, byteMatrix);
        g(byteMatrix.e() - 8, 7, byteMatrix);
        g(0, byteMatrix.e() - 8, byteMatrix);
        m(7, 0, byteMatrix);
        m((byteMatrix.d() - 7) - 1, 0, byteMatrix);
        m(7, byteMatrix.d() - 7, byteMatrix);
    }

    private static void k(ByteMatrix byteMatrix) {
        int i2 = 8;
        while (i2 < byteMatrix.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (o(byteMatrix.b(i2, 6))) {
                byteMatrix.f(i2, 6, i4);
            }
            if (o(byteMatrix.b(6, i2))) {
                byteMatrix.f(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        p(errorCorrectionLevel, i2, bitArray);
        for (int i3 = 0; i3 < bitArray.g(); i3++) {
            boolean f2 = bitArray.f((bitArray.g() - 1) - i3);
            int[] iArr = f31274d[i3];
            byteMatrix.g(iArr[0], iArr[1], f2);
            if (i3 < 8) {
                byteMatrix.g((byteMatrix.e() - i3) - 1, 8, f2);
            } else {
                byteMatrix.g(8, (byteMatrix.d() - 7) + (i3 - 8), f2);
            }
        }
    }

    private static void m(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int i4 = 0;
        while (i4 < 7) {
            int i5 = i3 + i4;
            if (o(byteMatrix.b(i2, i5))) {
                byteMatrix.f(i2, i5, 0);
                i4++;
            } else {
                throw new WriterException();
            }
        }
    }

    static int n(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitArray bitArray) throws WriterException {
        if (QRCode.b(i2)) {
            int a2 = (errorCorrectionLevel.a() << 3) | i2;
            bitArray.c(a2, 5);
            bitArray.c(b(a2, 1335), 10);
            BitArray bitArray2 = new BitArray();
            bitArray2.c(21522, 15);
            bitArray.k(bitArray2);
            if (bitArray.g() != 15) {
                throw new WriterException("should not happen but we got: " + bitArray.g());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void q(Version version, BitArray bitArray) throws WriterException {
        bitArray.c(version.f(), 6);
        bitArray.c(b(version.f(), 7973), 12);
        if (bitArray.g() != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.g());
        }
    }

    private static void r(Version version, ByteMatrix byteMatrix) {
        if (version.f() >= 2) {
            int[] iArr = f31273c[version.f() - 1];
            for (int i2 = 0; i2 < r0; i2++) {
                for (int i3 : iArr) {
                    int i4 = iArr[i2];
                    if (!(i3 == -1 || i4 == -1 || !o(byteMatrix.b(i3, i4)))) {
                        h(i3 - 2, i4 - 2, byteMatrix);
                    }
                }
            }
        }
    }

    static void s(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.f() >= 7) {
            BitArray bitArray = new BitArray();
            q(version, bitArray);
            int i2 = 17;
            for (int i3 = 0; i3 < 6; i3++) {
                for (int i4 = 0; i4 < 3; i4++) {
                    boolean f2 = bitArray.f(i2);
                    i2--;
                    byteMatrix.g(i3, (byteMatrix.d() - 11) + i4, f2);
                    byteMatrix.g((byteMatrix.d() - 11) + i4, i3, f2);
                }
            }
        }
    }
}
