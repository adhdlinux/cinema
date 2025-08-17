package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zze;

public final class zzavo extends zzavv {
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzavo(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    public final void zzb(int i2) {
    }

    public final void zzc(zze zze) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzd(zzavt zzavt) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzavp(zzavt, this.zzb));
        }
    }
}
