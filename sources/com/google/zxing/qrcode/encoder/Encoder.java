package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class Encoder {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f31269a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31270a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31270a = r0
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31270a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31270a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.AnonymousClass1.<clinit>():void");
        }
    }

    private Encoder() {
    }

    static void a(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte c2 : str.getBytes(str2)) {
                bitArray.c(c2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException((Throwable) e2);
        }
    }

    static void b(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int o2 = o(charSequence.charAt(i2));
            if (o2 != -1) {
                int i3 = i2 + 1;
                if (i3 < length) {
                    int o3 = o(charSequence.charAt(i3));
                    if (o3 != -1) {
                        bitArray.c((o2 * 45) + o3, 11);
                        i2 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    bitArray.c(o2, 6);
                    i2 = i3;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void c(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i2 = AnonymousClass1.f31270a[mode.ordinal()];
        if (i2 == 1) {
            h(str, bitArray);
        } else if (i2 == 2) {
            b(str, bitArray);
        } else if (i2 == 3) {
            a(str, bitArray, str2);
        } else if (i2 == 4) {
            e(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void d(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.c(Mode.ECI.a(), 4);
        bitArray.c(characterSetECI.b(), 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void e(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = -1
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.e(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    static void f(int i2, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int b2 = mode.b(version);
        int i3 = 1 << b2;
        if (i2 < i3) {
            bitArray.c(i2, b2);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void g(Mode mode, BitArray bitArray) {
        bitArray.c(mode.a(), 4);
    }

    static void h(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                bitArray.c((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    bitArray.c((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    bitArray.c(charAt, 4);
                }
            }
        }
    }

    private static int i(ByteMatrix byteMatrix) {
        return MaskUtil.a(byteMatrix) + MaskUtil.c(byteMatrix) + MaskUtil.d(byteMatrix) + MaskUtil.e(byteMatrix);
    }

    private static int j(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            MatrixUtil.a(bitArray, errorCorrectionLevel, version, i4, byteMatrix);
            int i5 = i(byteMatrix);
            if (i5 < i2) {
                i3 = i4;
                i2 = i5;
            }
        }
        return i3;
    }

    private static Mode k(String str, String str2) {
        if (!"Shift_JIS".equals(str2)) {
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt >= '0' && charAt <= '9') {
                    z3 = true;
                } else if (o(charAt) == -1) {
                    return Mode.BYTE;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                return Mode.ALPHANUMERIC;
            }
            if (z3) {
                return Mode.NUMERIC;
            }
            return Mode.BYTE;
        } else if (r(str)) {
            return Mode.KANJI;
        } else {
            return Mode.BYTE;
        }
    }

    private static Version l(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            Version e2 = Version.e(i3);
            if (e2.d() - e2.c(errorCorrectionLevel).d() >= (i2 + 7) / 8) {
                return e2;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode m(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String str2;
        int i2;
        CharacterSetECI a2;
        if (map == null) {
            str2 = null;
        } else {
            str2 = (String) map.get(EncodeHintType.CHARACTER_SET);
        }
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        Mode k2 = k(str, str2);
        BitArray bitArray = new BitArray();
        Mode mode = Mode.BYTE;
        if (k2 == mode && !"ISO-8859-1".equals(str2) && (a2 = CharacterSetECI.a(str2)) != null) {
            d(a2, bitArray);
        }
        g(k2, bitArray);
        BitArray bitArray2 = new BitArray();
        c(str, k2, bitArray2, str2);
        Version l2 = l(bitArray.g() + k2.b(l(bitArray.g() + k2.b(Version.e(1)) + bitArray2.g(), errorCorrectionLevel)) + bitArray2.g(), errorCorrectionLevel);
        BitArray bitArray3 = new BitArray();
        bitArray3.b(bitArray);
        if (k2 == mode) {
            i2 = bitArray2.h();
        } else {
            i2 = str.length();
        }
        f(i2, l2, k2, bitArray3);
        bitArray3.b(bitArray2);
        Version.ECBlocks c2 = l2.c(errorCorrectionLevel);
        int d2 = l2.d() - c2.d();
        s(d2, bitArray3);
        BitArray q2 = q(bitArray3, l2.d(), d2, c2.c());
        QRCode qRCode = new QRCode();
        qRCode.c(errorCorrectionLevel);
        qRCode.f(k2);
        qRCode.g(l2);
        int b2 = l2.b();
        ByteMatrix byteMatrix = new ByteMatrix(b2, b2);
        int j2 = j(q2, errorCorrectionLevel, l2, byteMatrix);
        qRCode.d(j2);
        MatrixUtil.a(q2, errorCorrectionLevel, l2, j2, byteMatrix);
        qRCode.e(byteMatrix);
        return qRCode;
    }

    static byte[] n(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[(length + i2)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new ReedSolomonEncoder(GenericGF.f31219l).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static int o(int i2) {
        int[] iArr = f31269a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void p(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            } else if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            } else if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    static BitArray q(BitArray bitArray, int i2, int i3, int i4) throws WriterException {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        if (bitArray.h() == i6) {
            ArrayList<BlockPair> arrayList = new ArrayList<>(i7);
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                p(i2, i3, i4, i11, iArr, iArr2);
                int i12 = iArr[0];
                byte[] bArr = new byte[i12];
                bitArray.j(i8 * 8, bArr, 0, i12);
                byte[] n2 = n(bArr, iArr2[0]);
                arrayList.add(new BlockPair(bArr, n2));
                i9 = Math.max(i9, i12);
                i10 = Math.max(i10, n2.length);
                i8 += iArr[0];
            }
            if (i6 == i8) {
                BitArray bitArray2 = new BitArray();
                for (int i13 = 0; i13 < i9; i13++) {
                    for (BlockPair a2 : arrayList) {
                        byte[] a3 = a2.a();
                        if (i13 < a3.length) {
                            bitArray2.c(a3[i13], 8);
                        }
                    }
                }
                for (int i14 = 0; i14 < i10; i14++) {
                    for (BlockPair b2 : arrayList) {
                        byte[] b3 = b2.b();
                        if (i14 < b3.length) {
                            bitArray2.c(b3[i14], 8);
                        }
                    }
                }
                if (i5 == bitArray2.h()) {
                    return bitArray2;
                }
                throw new WriterException("Interleaving error: " + i5 + " and " + bitArray2.h() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean r(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                byte b2 = bytes[i2] & 255;
                if ((b2 < 129 || b2 > 159) && (b2 < 224 || b2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void s(int i2, BitArray bitArray) throws WriterException {
        int i3;
        int i4 = i2 * 8;
        if (bitArray.g() <= i4) {
            for (int i5 = 0; i5 < 4 && bitArray.g() < i4; i5++) {
                bitArray.a(false);
            }
            int g2 = bitArray.g() & 7;
            if (g2 > 0) {
                while (g2 < 8) {
                    bitArray.a(false);
                    g2++;
                }
            }
            int h2 = i2 - bitArray.h();
            for (int i6 = 0; i6 < h2; i6++) {
                if ((i6 & 1) == 0) {
                    i3 = 236;
                } else {
                    i3 = 17;
                }
                bitArray.c(i3, 8);
            }
            if (bitArray.g() != i4) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitArray.g() + " > " + i4);
    }
}
