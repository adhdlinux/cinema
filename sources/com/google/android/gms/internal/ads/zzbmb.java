package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

final class zzbmb implements zzcal {
    final /* synthetic */ zzbmk zza;
    final /* synthetic */ zzffn zzb;
    final /* synthetic */ zzbml zzc;

    zzbmb(zzbml zzbml, zzbmk zzbmk, zzffn zzffn) {
        this.zzc = zzbml;
        this.zza = zzbmk;
        this.zzb = zzffn;
    }

    public final void zza() {
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
                zzbml zzbml = this.zzc;
                if (zzbml.zze != null) {
                    zzfgb zze = zzbml.zze;
                    zzffn zzffn = this.zzb;
                    zzffn.zzc("Failed loading new engine");
                    zzffn.zzf(false);
                    zze.zzb(zzffn.zzl());
                }
            }
        }
    }
}
