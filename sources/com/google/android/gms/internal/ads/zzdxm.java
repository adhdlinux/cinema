package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdxm implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzdxm(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    /* renamed from: zza */
    public final zzdxl zzb() {
        return new zzdxl(((zzcha) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
