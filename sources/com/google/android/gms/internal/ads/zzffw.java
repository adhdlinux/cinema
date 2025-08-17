package com.google.android.gms.internal.ads;

final class zzffw implements zzfvy {
    final /* synthetic */ zzffy zza;
    final /* synthetic */ zzffn zzb;

    zzffw(zzffy zzffy, zzffn zzffn) {
        this.zza = zzffy;
        this.zzb = zzffn;
    }

    public final void zza(Throwable th) {
        zzffy zzffy = this.zza;
        zzffn zzffn = this.zzb;
        zzffn.zzg(th);
        zzffn.zzf(false);
        zzffy.zza(zzffn);
    }

    public final void zzb(Object obj) {
    }
}
