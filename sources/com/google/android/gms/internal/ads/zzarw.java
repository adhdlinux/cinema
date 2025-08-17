package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.DisplayMetrics;

public final class zzarw {
    public static final /* synthetic */ int zza = 0;
    private static final char[] zzb = "0123456789abcdef".toCharArray();

    public static long zza(double d2, int i2, DisplayMetrics displayMetrics) {
        return Math.round(d2 / ((double) displayMetrics.density));
    }

    public static String zzb(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            char[] cArr2 = zzb;
            int i3 = i2 + i2;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static boolean zzc() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean zzd(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean zze(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static byte[] zzf(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i2 = 0; i2 < length; i2 += 2) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("String must be of even-length");
    }
}
