package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

final class zzdtn extends RewardedInterstitialAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzdtr zzc;

    zzdtn(zzdtr zzdtr, String str, String str2) {
        this.zzc = zzdtr;
        this.zza = str;
        this.zzb = str2;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzc.zzm(zzdtr.zzl(loadAdError), this.zzb);
    }

    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        this.zzc.zzg(this.zza, (RewardedInterstitialAd) obj, this.zzb);
    }
}
