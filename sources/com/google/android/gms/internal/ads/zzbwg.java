package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

public final class zzbwg extends zzbvt {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbwh zzb;

    public zzbwg(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbwh zzbwh) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbwh;
    }

    public final void zze(int i2) {
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzbwh zzbwh;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzbwh = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzbwh);
        }
    }
}
