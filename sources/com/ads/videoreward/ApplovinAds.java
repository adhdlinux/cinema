package com.ads.videoreward;

import android.app.Activity;
import com.ads.videoreward.AdsBase;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.movie.data.api.GlobalVariable;
import com.original.tase.Logger;

public class ApplovinAds extends AdsBase {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AppLovinAd f13586f = null;

    /* access modifiers changed from: private */
    public void t() {
        AppLovinSdk.getInstance(e()).getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                Logger.b("ApplovinAds", "loadNextAd - " + appLovinAd.getZoneId());
                AppLovinAd unused = ApplovinAds.this.f13586f = appLovinAd;
            }

            public void failedToReceiveAd(int i2) {
                AppLovinAd unused = ApplovinAds.this.f13586f = null;
                Logger.b("ApplovinAds", "failedToReceiveAd - " + i2);
            }
        });
    }

    public void f() {
        super.f();
        AppLovinSdk.initializeSdk(e(), new AppLovinSdk.SdkInitializationListener() {
            public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                Logger.b("ApplovinAds", "onSdkInitialized - " + appLovinSdkConfiguration.toString());
                ApplovinAds.this.t();
            }
        });
        n(GlobalVariable.c().b().getAds().getApplovin().getEcmp());
    }

    public void p(Activity activity) {
        if (this.f13586f != null) {
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(e()), e());
            create.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adDisplayed(AppLovinAd appLovinAd) {
                    AppLovinAd unused = ApplovinAds.this.f13586f = null;
                    ApplovinAds.this.t();
                }

                public void adHidden(AppLovinAd appLovinAd) {
                }
            });
            create.showAndRender(this.f13586f);
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
            return;
        }
        this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
    }
}
