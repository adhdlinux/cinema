package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zzd;

public final class zzf {
    private static SharedPreferences zza;

    public static SharedPreferences zza(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zza == null) {
                zza = (SharedPreferences) zzd.zza(new zze(context));
            }
            sharedPreferences = zza;
        }
        return sharedPreferences;
    }
}
