package com.ads.videoreward;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ads.videoreward.AdsBase;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.AppConfig;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public class StartApp extends AdsBase {

    /* renamed from: f  reason: collision with root package name */
    StartAppAd f13606f = null;

    public void f() {
        super.f();
        AppConfig.AdsBean.StartAppBean startApp = GlobalVariable.c().b().getAds().getStartApp();
        if (startApp != null) {
            StartAppSDK.init(e(), startApp.getApp_id(), true);
            if (!startApp.isEnable_splash_ads()) {
                StartAppAd.disableSplash();
            }
            StartAppSDK.setUserConsent(e(), "ACCESS_FINE_LOCATION ", System.currentTimeMillis(), true);
            StartAppSDK.enableReturnAds(false);
            this.f13606f = new StartAppAd(e());
        }
        n(startApp.getEcmp());
    }

    public void o(ViewGroup viewGroup) {
        Banner banner = new Banner(e());
        banner.setBannerListener(new BannerListener() {
            public void onClick(View view) {
            }

            public void onFailedToReceiveAd(View view) {
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
            }

            public void onImpression(View view) {
            }

            public void onReceiveAd(View view) {
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        viewGroup.addView(banner, layoutParams);
    }

    public void p(Activity activity) {
        this.f13606f.loadAd((AdEventListener) new AdEventListener() {
            public void onFailedToReceiveAd(Ad ad) {
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
            }

            public void onReceiveAd(Ad ad) {
                StartAppAd.showAd(StartApp.this.e());
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
            }
        });
    }

    public void q(FrameLayout frameLayout) {
        Banner banner = new Banner(e());
        banner.setBannerListener(new BannerListener() {
            public void onClick(View view) {
            }

            public void onFailedToReceiveAd(View view) {
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
            }

            public void onImpression(View view) {
            }

            public void onReceiveAd(View view) {
                StartApp startApp = StartApp.this;
                startApp.f13551e.b(startApp, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        frameLayout.addView(banner, layoutParams);
    }
}
