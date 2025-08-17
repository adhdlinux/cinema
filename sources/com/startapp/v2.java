package com.startapp;

import com.startapp.networkTest.enums.ThreeStateShort;

public class v2 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f36702a = "0123456789abcdef".toCharArray();

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = f36702a;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static int a(ThreeStateShort threeStateShort) {
        int ordinal = threeStateShort.ordinal();
        if (ordinal != 0) {
            return ordinal != 1 ? -1 : 0;
        }
        return 1;
    }
}
