package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzeaj implements zzfem {
    private final zzdzx zza;
    private final zzeab zzb;

    zzeaj(zzdzx zzdzx, zzeab zzeab) {
        this.zza = zzdzx;
        this.zzb = zzeab;
    }

    public final void zzbB(zzfef zzfef, String str) {
    }

    public final void zzbC(zzfef zzfef, String str, Throwable th) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && zzfef.RENDERER == zzfef && this.zza.zzc() != 0) {
            this.zza.zzf(zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzc(zzfef zzfef, String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            if (zzfef.RENDERER == zzfef) {
                this.zza.zzg(zzt.zzB().elapsedRealtime());
            } else if (zzfef.PRELOADED_LOADER == zzfef || zzfef.SERVER_TRANSACTION == zzfef) {
                this.zza.zzh(zzt.zzB().elapsedRealtime());
                zzeab zzeab = this.zzb;
                zzeab.zza.zza(new zzeaa(zzeab, this.zza.zzd()));
            }
        }
    }

    public final void zzd(zzfef zzfef, String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && zzfef.RENDERER == zzfef && this.zza.zzc() != 0) {
            this.zza.zzf(zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }
}
