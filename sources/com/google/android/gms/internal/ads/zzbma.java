package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

final class zzbma implements zzcan {
    final /* synthetic */ zzbmk zza;
    final /* synthetic */ zzffn zzb;
    final /* synthetic */ zzbml zzc;

    zzbma(zzbml zzbml, zzbmk zzbmk, zzffn zzffn) {
        this.zzc = zzbml;
        this.zza = zzbmk;
        this.zzb = zzffn;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzblg zzblg = (zzblg) obj;
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 0;
            zzbml zzbml = this.zzc;
            if (!(zzbml.zzh == null || this.zza == zzbml.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
                zzbml zzbml2 = this.zzc;
                if (zzbml2.zze != null) {
                    zzfgb zze = zzbml2.zze;
                    zzffn zzffn = this.zzb;
                    zzffn.zzf(true);
                    zze.zzb(zzffn.zzl());
                }
            }
        }
    }
}
