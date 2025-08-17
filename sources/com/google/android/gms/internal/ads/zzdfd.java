package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzdfd implements zzcrg {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzgwr zzd;
    private final zzdhl zze;

    zzdfd(Map map, Map map2, Map map3, zzgwr zzgwr, zzdhl zzdhl) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgwr;
        this.zze = zzdhl;
    }

    public final zzecc zza(int i2, String str) {
        zzecc zza2;
        zzecc zzecc = (zzecc) this.zza.get(str);
        if (zzecc != null) {
            return zzecc;
        }
        if (i2 != 1) {
            if (i2 != 4) {
                return null;
            }
            zzeeq zzeeq = (zzeeq) this.zzc.get(str);
            if (zzeeq != null) {
                return new zzecd(zzeeq, zzcri.zza);
            }
            zzecc zzecc2 = (zzecc) this.zzb.get(str);
            if (zzecc2 == null) {
                return null;
            }
            return zzcrk.zza(zzecc2);
        } else if (this.zze.zze() == null || (zza2 = ((zzcrg) this.zzd.zzb()).zza(i2, str)) == null) {
            return null;
        } else {
            return zzcrk.zza(zza2);
        }
    }
}
