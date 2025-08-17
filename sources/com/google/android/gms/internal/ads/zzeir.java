package com.google.android.gms.internal.ads;

final class zzeir implements zzekb {
    final /* synthetic */ zzeis zza;

    zzeir(zzeis zzeis) {
        this.zza = zzeis;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpb zzcpb = (zzcpb) obj;
        synchronized (this.zza) {
            zzeis zzeis = this.zza;
            if (zzeis.zzi != null) {
                zzeis.zzi.zzb();
            }
            this.zza.zzi = zzcpb;
            this.zza.zzi.zzj();
        }
    }
}
