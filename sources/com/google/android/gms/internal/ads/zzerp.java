package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzerp implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;

    public zzerp(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6, zzgwr zzgwr7) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
        this.zzg = zzgwr7;
    }

    public static zzern zza(zzbyr zzbyr, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i2, boolean z2, boolean z3) {
        return new zzern(zzbyr, context, scheduledExecutorService, executor, i2, z2, z3);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzern(new zzbyr(), ((zzcha) this.zzb).zza(), (ScheduledExecutorService) this.zzc.zzb(), zzfwn, ((zzetu) this.zze).zzb().intValue(), ((zzetv) this.zzf).zzb().booleanValue(), ((zzetx) this.zzg).zzb().booleanValue());
    }
}
