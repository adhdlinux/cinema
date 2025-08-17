package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzduo implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzduo(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager((Context) this.zza.zzb()).getPackageInfo(((zzduj) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
