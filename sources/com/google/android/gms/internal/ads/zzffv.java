package com.google.android.gms.internal.ads;

final class zzffv implements zzfvy {
    final /* synthetic */ zzffy zza;
    final /* synthetic */ zzffn zzb;
    final /* synthetic */ boolean zzc;

    zzffv(zzffy zzffy, zzffn zzffn, boolean z2) {
        this.zza = zzffy;
        this.zzb = zzffn;
        this.zzc = z2;
    }

    public final void zza(Throwable th) {
        zzffn zzffn = this.zzb;
        if (zzffn.zzj()) {
            zzffy zzffy = this.zza;
            zzffn.zzg(th);
            zzffn.zzf(false);
            zzffy.zza(zzffn);
            if (this.zzc) {
                this.zza.zzg();
            }
        }
    }

    public final void zzb(Object obj) {
        zzffy zzffy = this.zza;
        zzffn zzffn = this.zzb;
        zzffn.zzf(true);
        zzffy.zza(zzffn);
        if (this.zzc) {
            this.zza.zzg();
        }
    }
}
