package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzbbz extends zzbca {
    zzbbz() {
    }

    private static final String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < str.length() && str.charAt(i3) == ',') {
            i3++;
        }
        while (length > 0) {
            int i4 = length - 1;
            if (str.charAt(i4) != ',') {
                break;
            }
            length = i4;
        }
        if (length < i3) {
            return null;
        }
        if (i3 != 0) {
            i2 = i3;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i2, length);
    }

    public final String zza(String str, String str2) {
        String zzb = zzb(str);
        String zzb2 = zzb(str2);
        if (TextUtils.isEmpty(zzb)) {
            return zzb2;
        }
        if (TextUtils.isEmpty(zzb2)) {
            return zzb;
        }
        return zzb + "," + zzb2;
    }
}
