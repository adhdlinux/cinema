package com.google.android.gms.internal.ads;

final class zzevs implements zzekb {
    final /* synthetic */ zzevt zza;

    zzevs(zzevt zzevt) {
        this.zza = zzevt;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcov zzcov = (zzcov) obj;
        synchronized (this.zza) {
            zzcov zzcov2 = this.zza.zza;
            if (zzcov2 != null) {
                zzcov2.zzb();
            }
            zzevt zzevt = this.zza;
            zzevt.zza = zzcov;
            zzcov.zzc(zzevt);
            zzevt zzevt2 = this.zza;
            zzevt2.zzg.zzl(new zzcow(zzcov, zzevt2, zzevt2.zzg, zzevt2.zzi));
            zzcov.zzj();
        }
    }
}
