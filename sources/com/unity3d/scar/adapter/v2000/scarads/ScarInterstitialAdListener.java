package com.unity3d.scar.adapter.v2000.scarads;

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
    public final ScarInterstitialAd f37148b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final IScarInterstitialAdListenerWrapper f37149c;

    /* renamed from: d  reason: collision with root package name */
    private final InterstitialAdLoadCallback f37150d = new InterstitialAdLoadCallback() {
        /* renamed from: a */
        public void onAdLoaded(InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            ScarInterstitialAdListener.this.f37149c.onAdLoaded();
            interstitialAd.setFullScreenContentCallback(ScarInterstitialAdListener.this.f37151e);
            ScarInterstitialAdListener.this.f37148b.d(interstitialAd);
            IScarLoadListener iScarLoadListener = ScarInterstitialAdListener.this.f37147a;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarInterstitialAdListener.this.f37149c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final FullScreenContentCallback f37151e = new FullScreenContentCallback() {
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarInterstitialAdListener.this.f37149c.onAdClosed();
        }

        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarInterstitialAdListener.this.f37149c.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarInterstitialAdListener.this.f37149c.onAdImpression();
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarInterstitialAdListener.this.f37149c.onAdOpened();
        }
    };

    public ScarInterstitialAdListener(IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper, ScarInterstitialAd scarInterstitialAd) {
        this.f37149c = iScarInterstitialAdListenerWrapper;
        this.f37148b = scarInterstitialAd;
    }

    public InterstitialAdLoadCallback e() {
        return this.f37150d;
    }
}
