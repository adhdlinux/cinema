package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

final class zzedv implements zzfvy {
    final /* synthetic */ zzedw zza;

    zzedv(zzedw zzedw) {
        this.zza = zzedw;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zza(zza2);
        zzfbc.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcpb) obj).zzj();
    }
}
