package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

@Deprecated
public final class zzbbw {
    public static boolean zza(zzbce zzbce, zzbcb zzbcb, String... strArr) {
        if (zzbcb == null) {
            return false;
        }
        zzbce.zze(zzbcb, zzt.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
