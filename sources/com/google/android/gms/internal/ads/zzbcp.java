package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzbcp implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzbcp(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
    }

    public final /* synthetic */ Object zzb() {
        return new zzbco(((zzcha) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb(), new zzbcq(), (zzffy) this.zzd.zzb());
    }
}
