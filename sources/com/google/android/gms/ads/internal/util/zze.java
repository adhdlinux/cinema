package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzbzr;

public final class zze extends zzbzr {
    public static void zza(String str) {
        if (!zzc()) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.v(AdRequest.LOGTAG, str);
            return;
        }
        boolean z2 = true;
        for (String str2 : zzbzr.zza.zzd(str)) {
            if (z2) {
                Log.v(AdRequest.LOGTAG, str2);
            } else {
                Log.v("Ads-cont", str2);
            }
            z2 = false;
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzc() {
        if (!zzbzr.zzm(2) || !((Boolean) zzbdi.zza.zze()).booleanValue()) {
            return false;
        }
        return true;
    }
}
