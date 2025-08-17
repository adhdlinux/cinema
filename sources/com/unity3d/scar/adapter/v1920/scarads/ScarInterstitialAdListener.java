package com.unity3d.scar.adapter.v1920.scarads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarInterstitialAdListener {

    /* renamed from: a  reason: collision with root package name */
    private InterstitialAd f37083a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IScarInterstitialAdListenerWrapper f37084b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IScarLoadListener f37085c;

    /* renamed from: d  reason: collision with root package name */
    private AdListener f37086d = new AdListener() {
        public void onAdClicked() {
            ScarInterstitialAdListener.this.f37084b.onAdClicked();
        }

        public void onAdClosed() {
            ScarInterstitialAdListener.this.f37084b.onAdClosed();
        }

        public void onAdLoaded() {
            ScarInterstitialAdListener.this.f37084b.onAdLoaded();
            if (ScarInterstitialAdListener.this.f37085c != null) {
                ScarInterstitialAdListener.this.f37085c.onAdLoaded();
            }
        }

        public void onAdOpened() {
            ScarInterstitialAdListener.this.f37084b.onAdOpened();
        }
    };

    public ScarInterstitialAdListener(InterstitialAd interstitialAd, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        this.f37083a = interstitialAd;
        this.f37084b = iScarInterstitialAdListenerWrapper;
    }

    public AdListener c() {
        return this.f37086d;
    }

    public void d(IScarLoadListener iScarLoadListener) {
        this.f37085c = iScarLoadListener;
    }
}
