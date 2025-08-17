package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdxp implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzdxp(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    /* renamed from: zza */
    public final zzdxo zzb() {
        return new zzdxo(((zzcha) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
