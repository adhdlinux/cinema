package com.startapp;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class fc {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f34529a = {10, 30, 84, 95, 101, 20, 0, 14, 15, 80, 36, 84, 64, 82, 84, 64, 80, 80, 65, 78, 84, 73, 70, 82, 65, 85, 68, 75, 69, 89, 1, 2, 3, 8, 15, 42, 10, 51, 44, 32};

    /* renamed from: b  reason: collision with root package name */
    public static final String f34530b = "ts";

    /* renamed from: c  reason: collision with root package name */
    public static final String f34531c = "tsh";

    /* renamed from: d  reason: collision with root package name */
    public static final String f34532d = "afh";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34533e = "MD5";

    /* renamed from: f  reason: collision with root package name */
    public static final String f34534f = "UTF-8";

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f34535g = {12, 31, 86, 96, 103, 10, 28, 15, 17, 28, 36, 84, 64, 82, 84, 64, 80, 80, 69, 78, 67, 82, 89, 80, 84, 73, 79, 78, 75, 69, 89, 4, 32, 18, 16, 18, 11, 53, 45, 34};

    static {
        hc.a((Class<?>) fc.class);
    }

    public static String a() {
        int hashCode = f34529a.hashCode();
        long currentTimeMillis = System.currentTimeMillis();
        if (hashCode > 0) {
            int i2 = (int) ((((currentTimeMillis * 25214903917L) + 11) & 281474976710655L) >>> 17);
            if (((-hashCode) & hashCode) != hashCode) {
                int i3 = i2 % hashCode;
            }
        }
        return new Long(System.currentTimeMillis()).toString();
    }

    public static String b(String str) {
        return Base64.encodeToString(a(str.getBytes()), 2);
    }

    public static String c(String str) {
        String str2;
        if (str != null) {
            try {
                str2 = URLDecoder.decode(str, f34534f);
            } catch (UnsupportedEncodingException unused) {
            }
            String a2 = a();
            return "&" + f34530b + "=" + a2 + "&" + f34532d + "=" + a(str2 + a2);
        }
        str2 = "";
        String a22 = a();
        return "&" + f34530b + "=" + a22 + "&" + f34532d + "=" + a(str2 + a22);
    }

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = f34529a;
        int length = bytes.length < bArr.length ? bytes.length : bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bytes[i2];
            byte b3 = bArr[i2];
        }
        byte[] bytes2 = str.getBytes();
        byte b4 = f34529a[5];
        byte[] bArr2 = new byte[Math.min(bytes2.length, b4)];
        for (int i3 = 0; i3 < bytes2.length; i3++) {
            int i4 = i3 % b4;
            bArr2[i4] = (byte) (bArr2[i4] ^ bytes2[i3]);
        }
        byte[] bArr3 = f34529a;
        try {
            return URLEncoder.encode(Base64.encodeToString(MessageDigest.getInstance(f34533e).digest(a(bArr2, new String(bArr3).substring(bArr3[0], bArr3[1]).getBytes())), 3), f34534f);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = f34535g;
        int hashCode = bArr2.hashCode();
        long hashCode2 = (long) bArr.hashCode();
        if (((long) hashCode) > hashCode2) {
            int i2 = (int) ((((hashCode2 * 29509871405L) + 11) & 16777215) >>> 17);
            if (hashCode >= 1000) {
                int i3 = i2 % hashCode;
            }
        }
        return a(a(bArr, new String(bArr2).substring(bArr2[5], bArr2[33]).getBytes()), new String(bArr2).substring(bArr2[35], bArr2[1]).getBytes());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
        }
        return bArr3;
    }
}
