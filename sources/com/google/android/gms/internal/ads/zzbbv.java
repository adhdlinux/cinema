package com.google.android.gms.internal.ads;

import android.text.TextUtils;

@Deprecated
public final class zzbbv {
    public static final void zza(zzbbu zzbbu, zzbbs zzbbs) {
        if (zzbbs.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzbbs.zzb())) {
            zzbbu.zzd(zzbbs.zza(), zzbbs.zzb(), zzbbs.zzc(), zzbbs.zzd());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
