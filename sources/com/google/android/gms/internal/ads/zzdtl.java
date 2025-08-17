package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

final class zzdtl extends InterstitialAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzdtr zzc;

    zzdtl(zzdtr zzdtr, String str, String str2) {
        this.zzc = zzdtr;
        this.zza = str;
        this.zzb = str2;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzc.zzm(zzdtr.zzl(loadAdError), this.zzb);
    }

    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        this.zzc.zzg(this.zza, (InterstitialAd) obj, this.zzb);
    }
}
