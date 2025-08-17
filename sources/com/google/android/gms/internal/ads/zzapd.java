package com.google.android.gms.internal.ads;

import android.util.Base64;

public final class zzapd {
    public static String zza(byte[] bArr, boolean z2) {
        return Base64.encodeToString(bArr, true != z2 ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z2) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str, 2);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
