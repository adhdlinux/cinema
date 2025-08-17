package com.google.android.gms.internal.ads;

public final class zzgmz {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(r1 + r1);
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            sb.append("0123456789abcdef".charAt(b3 >> 4));
            sb.append("0123456789abcdef".charAt(b3 & 15));
        }
        return sb.toString();
    }
}
