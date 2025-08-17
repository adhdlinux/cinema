package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Set;

public final class zzca {
    public static zzby zza(Context context, String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("/", -1);
        int length = split.length;
        if (length == 1) {
            str3 = String.valueOf(context.getPackageName()).concat("_preferences");
            str2 = split[0];
        } else {
            if (length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
            return null;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            return new zzby(str3, str2);
        }
        return null;
    }

    public static void zzb(Context context, Set<String> set) {
        String str;
        zzbz zzbz = new zzbz(context);
        for (String next : set) {
            zzby zza = zza(context, next);
            if (zza == null) {
                String valueOf = String.valueOf(next);
                if (valueOf.length() != 0) {
                    str = "clearKeys: unable to process key: ".concat(valueOf);
                } else {
                    str = new String("clearKeys: unable to process key: ");
                }
                Log.d("UserMessagingPlatform", str);
            } else {
                zzbz.zzd(zza.zza).remove(zza.zzb);
            }
        }
        zzbz.zzb();
    }
}
