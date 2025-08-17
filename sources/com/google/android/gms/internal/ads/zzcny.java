package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcny implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzcny(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcnx((zzbni) this.zza.zzb(), (zzcnt) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzcns) this.zzd.zzb(), (Clock) this.zze.zzb());
    }
}
