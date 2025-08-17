package com.unity3d.scar.adapter.v1950.scarads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarInterstitialAdListener {

    /* renamed from: a  reason: collision with root package name */
    private InterstitialAd f37115a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IScarInterstitialAdListenerWrapper f37116b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IScarLoadListener f37117c;

    /* renamed from: d  reason: collision with root package name */
    private AdListener f37118d = new AdListener() {
        public void onAdClicked() {
            ScarInterstitialAdListener.this.f37116b.onAdClicked();
        }

        public void onAdClosed() {
            ScarInterstitialAdListener.this.f37116b.onAdClosed();
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ScarInterstitialAdListener.this.f37116b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }

        public void onAdLoaded() {
            ScarInterstitialAdListener.this.f37116b.onAdLoaded();
            if (ScarInterstitialAdListener.this.f37117c != null) {
                ScarInterstitialAdListener.this.f37117c.onAdLoaded();
            }
        }

        public void onAdOpened() {
            ScarInterstitialAdListener.this.f37116b.onAdOpened();
        }
    };

    public ScarInterstitialAdListener(InterstitialAd interstitialAd, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        this.f37115a = interstitialAd;
        this.f37116b = iScarInterstitialAdListenerWrapper;
    }

    public AdListener c() {
        return this.f37118d;
    }

    public void d(IScarLoadListener iScarLoadListener) {
        this.f37117c = iScarLoadListener;
    }
}
