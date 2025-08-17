package com.google.android.gms.internal.ads;

final class zzcrp implements zzfvy {
    final /* synthetic */ zzfvy zza;
    final /* synthetic */ zzcrr zzb;

    zzcrp(zzcrr zzcrr, zzfvy zzfvy) {
        this.zzb = zzcrr;
        this.zza = zzfvy;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzcae.zze.execute(new zzcro(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcrr.zzb(this.zzb, ((zzcrk) obj).zza, this.zza);
    }
}
