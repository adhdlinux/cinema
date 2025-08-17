package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarInterstitialAdListener extends ScarAdListener {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScarInterstitialAd f37182b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final IScarInterstitialAdListenerWrapper f37183c;

    /* renamed from: d  reason: collision with root package name */
    private final InterstitialAdLoadCallback f37184d = new InterstitialAdLoadCallback() {
        /* renamed from: a */
        public void onAdLoaded(InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            ScarInterstitialAdListener.this.f37183c.onAdLoaded();
            interstitialAd.setFullScreenContentCallback(ScarInterstitialAdListener.this.f37185e);
            ScarInterstitialAdListener.this.f37182b.d(interstitialAd);
            IScarLoadListener iScarLoadListener = ScarInterstitialAdListener.this.f37181a;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarInterstitialAdListener.this.f37183c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final FullScreenContentCallback f37185e = new FullScreenContentCallback() {
        public void onAdClicked() {
            super.onAdClicked();
            ScarInterstitialAdListener.this.f37183c.onAdClicked();
        }

        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarInterstitialAdListener.this.f37183c.onAdClosed();
        }

        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarInterstitialAdListener.this.f37183c.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarInterstitialAdListener.this.f37183c.onAdImpression();
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarInterstitialAdListener.this.f37183c.onAdOpened();
        }
    };

    public ScarInterstitialAdListener(IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper, ScarInterstitialAd scarInterstitialAd) {
        this.f37183c = iScarInterstitialAdListenerWrapper;
        this.f37182b = scarInterstitialAd;
    }

    public InterstitialAdLoadCallback e() {
        return this.f37184d;
    }
}
