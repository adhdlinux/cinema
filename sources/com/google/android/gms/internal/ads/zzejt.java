package com.google.android.gms.internal.ads;

final class zzejt implements zzekb {
    final /* synthetic */ zzeju zza;

    zzejt(zzeju zzeju) {
        this.zza = zzeju;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzddn zzddn = (zzddn) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzddn;
            this.zza.zzj.zzj();
        }
    }
}
