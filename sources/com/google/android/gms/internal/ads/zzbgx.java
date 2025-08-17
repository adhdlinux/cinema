package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzbu;

final class zzbgx implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbu zzb;
    final /* synthetic */ zzbgy zzc;

    zzbgx(zzbgy zzbgy, AdManagerAdView adManagerAdView, zzbu zzbu) {
        this.zzc = zzbgy;
        this.zza = adManagerAdView;
        this.zzb = zzbu;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            this.zzc.zza.onAdManagerAdViewLoaded(this.zza);
        } else {
            zzbzr.zzj("Could not bind.");
        }
    }
}
