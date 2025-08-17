package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzt;

final class zzbyw extends zzb {
    final /* synthetic */ zzbza zza;

    zzbyw(zzbza zzbza) {
        this.zza = zzbza;
    }

    public final void zza() {
        zzbza zzbza = this.zza;
        zzbbs zzbbs = new zzbbs(zzbza.zze, zzbza.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                zzt.zze();
                zzbbv.zza(this.zza.zzh, zzbbs);
            } catch (IllegalArgumentException e2) {
                zzbzr.zzk("Cannot config CSI reporter.", e2);
            }
        }
    }
}
