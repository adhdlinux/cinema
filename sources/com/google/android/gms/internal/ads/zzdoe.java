package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdoe implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzdoe(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        int i2;
        Context zza2 = ((zzcha) this.zza).zza();
        String zza3 = ((zzdup) this.zzb).zzb();
        zzbzx zza4 = ((zzchm) this.zzc).zza();
        zzaxj zzaxj = (zzaxj) this.zzd.zzb();
        String str = (String) this.zze.zzb();
        zzawz zzawz = new zzawz(new zzaxf(zza2));
        zzazy zza5 = zzazz.zza();
        zza5.zza(zza4.zzb);
        zza5.zzc(zza4.zzc);
        if (true != zza4.zzd) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        zza5.zzb(i2);
        zzawz.zzb(new zzdod(zzaxj, zza3, (zzazz) zza5.zzal(), str));
        return zzawz;
    }
}
