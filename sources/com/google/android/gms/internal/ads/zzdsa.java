package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

final class zzdsa implements zzfvy {
    final /* synthetic */ zzdsc zza;

    zzdsa(zzdsc zzdsc) {
        this.zza = zzdsc;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzt.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zze(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (zzt.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzdrz(this, str));
        }
    }
}
