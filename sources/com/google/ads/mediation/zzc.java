package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class zzc extends InterstitialAdLoadCallback {

    /* renamed from: a  reason: collision with root package name */
    final AbstractAdViewAdapter f22252a;

    /* renamed from: b  reason: collision with root package name */
    final MediationInterstitialListener f22253b;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f22252a = abstractAdViewAdapter;
        this.f22253b = mediationInterstitialListener;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f22253b.onAdFailedToLoad((MediationInterstitialAdapter) this.f22252a, (AdError) loadAdError);
    }

    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        AbstractAdViewAdapter abstractAdViewAdapter = this.f22252a;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd;
        interstitialAd.setFullScreenContentCallback(new zzd(abstractAdViewAdapter, this.f22253b));
        this.f22253b.onAdLoaded(this.f22252a);
    }
}
