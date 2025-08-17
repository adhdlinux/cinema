package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

public final class zzctv implements zzcyb {
    private final Context zza;
    private final zzfai zzb;
    private final zzbzx zzc;
    private final zzg zzd;
    private final zzdsc zze;
    private final zzfgb zzf;

    public zzctv(Context context, zzfai zzfai, zzbzx zzbzx, zzg zzg, zzdsc zzdsc, zzfgb zzfgb) {
        this.zza = context;
        this.zzb = zzfai;
        this.zzc = zzbzx;
        this.zzd = zzg;
        this.zze = zzdsc;
        this.zzf = zzfgb;
    }

    public final void zzb(zzezz zzezz) {
    }

    public final void zzbA(zzbue zzbue) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdH)).booleanValue()) {
            zzt.zza().zzc(this.zza, this.zzc, this.zzb.zzf, this.zzd.zzh(), this.zzf);
        }
        this.zze.zzr();
    }
}
