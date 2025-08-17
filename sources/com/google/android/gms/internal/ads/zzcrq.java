package com.google.android.gms.internal.ads;

final class zzcrq implements zzfvy {
    final /* synthetic */ zzfvy zza;
    final /* synthetic */ zzcrr zzb;

    zzcrq(zzcrr zzcrr, zzfvy zzfvy) {
        this.zzb = zzcrr;
        this.zza = zzfvy;
    }

    public final void zza(Throwable th) {
        zzcae.zze.execute(new zzcro(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcae.zze.execute(new zzcro(this.zzb));
        this.zza.zzb((zzcrd) obj);
    }
}
