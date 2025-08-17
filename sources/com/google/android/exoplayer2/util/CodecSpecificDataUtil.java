package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CodecSpecificDataUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f28652a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f28653b = {"", "A", "B", "C"};

    private CodecSpecificDataUtil() {
    }

    public static String a(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public static List<byte[]> b(boolean z2) {
        return Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i2, boolean z2, int i3, int i4, int[] iArr, int i5) {
        char c2;
        Object[] objArr = new Object[5];
        objArr[0] = f28653b[i2];
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i4);
        if (z2) {
            c2 = 'H';
        } else {
            c2 = 'L';
        }
        objArr[3] = Character.valueOf(c2);
        objArr[4] = Integer.valueOf(i5);
        StringBuilder sb = new StringBuilder(Util.C("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i6])}));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f28652a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int e(byte[] bArr, int i2) {
        int length = bArr.length - f28652a.length;
        while (i2 <= length) {
            if (g(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static Pair<Integer, Integer> f(byte[] bArr) {
        boolean z2;
        boolean z3;
        boolean z4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 3;
            if (i4 < bArr.length) {
                if (parsableByteArray.K() == 1 && (bArr[i4] & 240) == 32) {
                    z2 = true;
                    break;
                }
                parsableByteArray.U(parsableByteArray.f() - 2);
                i3++;
            } else {
                z2 = false;
                break;
            }
        }
        Assertions.b(z2, "Invalid input: VOL not found.");
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.r((i3 + 4) * 8);
        parsableBitArray.r(1);
        parsableBitArray.r(8);
        if (parsableBitArray.g()) {
            parsableBitArray.r(4);
            parsableBitArray.r(3);
        }
        if (parsableBitArray.h(4) == 15) {
            parsableBitArray.r(8);
            parsableBitArray.r(8);
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(2);
            parsableBitArray.r(1);
            if (parsableBitArray.g()) {
                parsableBitArray.r(79);
            }
        }
        if (parsableBitArray.h(2) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.b(z3, "Only supports rectangular video object layer shape.");
        Assertions.a(parsableBitArray.g());
        int h2 = parsableBitArray.h(16);
        Assertions.a(parsableBitArray.g());
        if (parsableBitArray.g()) {
            if (h2 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.a(z4);
            for (int i5 = h2 - 1; i5 > 0; i5 >>= 1) {
                i2++;
            }
            parsableBitArray.r(i2);
        }
        Assertions.a(parsableBitArray.g());
        int h3 = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        int h4 = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        parsableBitArray.r(1);
        return Pair.create(Integer.valueOf(h3), Integer.valueOf(h4));
    }

    private static boolean g(byte[] bArr, int i2) {
        if (bArr.length - i2 <= f28652a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f28652a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    public static Pair<Integer, Integer> h(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.U(9);
        int H = parsableByteArray.H();
        parsableByteArray.U(20);
        return Pair.create(Integer.valueOf(parsableByteArray.L()), Integer.valueOf(H));
    }

    public static boolean i(List<byte[]> list) {
        if (list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1) {
            return true;
        }
        return false;
    }

    public static byte[][] j(byte[] bArr) {
        int i2;
        if (!g(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        do {
            arrayList.add(Integer.valueOf(i3));
            i3 = e(bArr, i3 + f28652a.length);
        } while (i3 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            int intValue = ((Integer) arrayList.get(i4)).intValue();
            if (i4 < arrayList.size() - 1) {
                i2 = ((Integer) arrayList.get(i4 + 1)).intValue();
            } else {
                i2 = bArr.length;
            }
            int i5 = i2 - intValue;
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr, intValue, bArr3, 0, i5);
            bArr2[i4] = bArr3;
        }
        return bArr2;
    }
}
