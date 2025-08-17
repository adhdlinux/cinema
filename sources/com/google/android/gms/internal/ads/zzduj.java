package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzduj implements zzgwe {
    private final zzgwr zza;

    public zzduj(zzgwr zzgwr) {
        this.zza = zzgwr;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzgwm.zzb(applicationInfo);
        return applicationInfo;
    }
}
