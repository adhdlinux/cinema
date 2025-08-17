package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzcpf implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;

    public zzcpf(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6, zzgwr zzgwr7, zzgwr zzgwr8, zzgwr zzgwr9, zzgwr zzgwr10) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
        this.zzg = zzgwr7;
        this.zzh = zzgwr8;
        this.zzi = zzgwr9;
        this.zzj = zzgwr10;
    }

    public static zzcpe zzc(zzcrc zzcrc, Context context, zzezo zzezo, View view, zzcez zzcez, zzcrb zzcrb, zzdhl zzdhl, zzdcw zzdcw, zzgvy zzgvy, Executor executor) {
        return new zzcpe(zzcrc, context, zzezo, view, zzcez, zzcrb, zzdhl, zzdcw, zzgvy, executor);
    }

    /* renamed from: zza */
    public final zzcpe zzb() {
        return new zzcpe(((zzctc) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcpl) this.zzc).zza(), ((zzcpk) this.zzd).zza(), ((zzcpw) this.zze).zza(), ((zzcpm) this.zzf).zza(), ((zzdfi) this.zzg).zza(), (zzdcw) this.zzh.zzb(), zzgwd.zza(this.zzi), (Executor) this.zzj.zzb());
    }
}
