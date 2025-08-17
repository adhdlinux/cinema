package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

final class zzezd implements zzekb {
    final /* synthetic */ zzeze zza;

    zzezd(zzeze zzeze) {
        this.zza = zzeze;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzi = (zzdmm) obj;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdh)).booleanValue()) {
                ((zzdmm) obj).zzd().zza = this.zza.zzd;
            }
            this.zza.zzi.zzj();
        }
    }
}
