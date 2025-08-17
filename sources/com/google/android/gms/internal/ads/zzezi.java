package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

final class zzezi implements zzekb {
    final /* synthetic */ zzezk zza;

    zzezi(zzezk zzezk) {
        this.zza = zzezk;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzd = (zzdmm) obj;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdh)).booleanValue()) {
                ((zzdmm) obj).zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzj();
        }
    }
}
