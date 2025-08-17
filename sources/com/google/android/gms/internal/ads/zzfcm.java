package com.google.android.gms.internal.ads;

final class zzfcm implements zzfvy {
    final /* synthetic */ zzfcp zza;
    final /* synthetic */ zzfcq zzb;

    zzfcm(zzfcq zzfcq, zzfcp zzfcp) {
        this.zzb = zzfcq;
        this.zza = zzfcp;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfcq zzfcq = this.zzb;
            if (zzfcq.zzf == 1) {
                zzfcq.zzh();
            }
        }
    }
}
