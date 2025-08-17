package com.ads.videoreward;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ads.videoreward.AdsBase;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.AppConfig;
import com.original.tase.Logger;
import com.original.tase.utils.DeviceUtils;
import com.utils.Utils;
import com.yoku.house.ads.HouseAdsDialog;
import com.yoku.house.ads.HouseAdsInterstitial;
import com.yoku.house.ads.HouseAdsNative;
import com.yoku.house.ads.helper.JsonPullerTask;
import com.yoku.house.ads.helper.cacheImages.PicassoHelper;
import com.yoku.house.ads.listener.AdListener;
import com.yoku.house.ads.listener.NativeAdListener;
import w.b;

public class HouseAds extends AdsBase {

    /* renamed from: f  reason: collision with root package name */
    private HouseAdsInterstitial f13594f;

    /* renamed from: g  reason: collision with root package name */
    private HouseAdsNative f13595g;

    /* renamed from: h  reason: collision with root package name */
    private HouseAdsDialog f13596h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13597i = false;

    /* access modifiers changed from: private */
    public /* synthetic */ void s(String str) {
        if (!str.trim().isEmpty()) {
            u(str);
            t(str);
            v(str);
            this.f13597i = true;
        }
    }

    private void t(String str) {
        HouseAdsDialog houseAdsDialog = new HouseAdsDialog(e(), str);
        this.f13596h = houseAdsDialog;
        houseAdsDialog.q(true);
        this.f13596h.p(true);
        this.f13596h.n(new AdListener() {
            public void a(Exception exc) {
                Logger.b("HouseAds", "setupDialog onAdLoadFailed " + exc.getMessage());
            }

            public void b() {
                Logger.b("HouseAds", "Intertisial onAdShown");
            }

            public void c() {
                Logger.b("HouseAds", "setupDialog onAdShown");
            }

            public void onAdClosed() {
                Logger.b("HouseAds", "setupDialog onAdClosed");
            }

            public void onAdLoaded() {
                Logger.b("HouseAds", "setupDialog onAdLoaded");
            }
        });
        this.f13596h.m();
    }

    private void u(String str) {
        HouseAdsInterstitial houseAdsInterstitial = new HouseAdsInterstitial(e(), str);
        this.f13594f = houseAdsInterstitial;
        houseAdsInterstitial.h(new AdListener() {
            public void a(Exception exc) {
                Logger.b("HouseAds", "onAdLoadFailed " + exc.getMessage());
            }

            public void b() {
                Logger.b("HouseAds", "Intertisial onApplicationLeft");
            }

            public void c() {
                Logger.b("HouseAds", "Intertisial onAdShown");
            }

            public void onAdClosed() {
                Logger.b("HouseAds", "Intertisial onAdClosed");
            }

            public void onAdLoaded() {
                Logger.b("HouseAds", "Intertisial onAdLoaded");
            }
        });
        this.f13594f.g();
    }

    private void v(String str) {
        HouseAdsNative houseAdsNative = new HouseAdsNative(e(), str);
        this.f13595g = houseAdsNative;
        houseAdsNative.m(true);
        this.f13595g.j(new NativeAdListener() {
            public void a(Exception exc) {
                Logger.b("HouseAds", "setupNative onAdLoadFailed " + exc.getMessage());
            }

            public void onAdLoaded() {
                Logger.b("HouseAds", "setupNative onAdLoaded");
            }
        });
        this.f13595g.i();
    }

    public void b() {
        super.b();
    }

    public void f() {
        super.f();
        if (Utils.f0() && !DeviceUtils.c()) {
            PicassoHelper.a(e());
            AppConfig.AdsBean.HouseAdsBean house_ads = GlobalVariable.c().b().getAds().getHouse_ads();
            String config = house_ads.getConfig();
            n(house_ads.getEcmp());
            if (!config.trim().isEmpty()) {
                new JsonPullerTask(config, new b(this)).execute(new String[0]);
                return;
            }
            throw new IllegalArgumentException("Url is Blank!");
        }
    }

    public void g(int i2, int i3, Intent intent) {
        super.g(i2, i3, intent);
    }

    public void o(ViewGroup viewGroup) {
        if (!this.f13597i || !this.f13595g.l(viewGroup, true)) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
        } else {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
        }
    }

    public void p(Activity activity) {
        if (!this.f13597i || !this.f13594f.f()) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
            return;
        }
        this.f13594f.j();
        this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
    }

    public void q(FrameLayout frameLayout) {
        if (!this.f13597i || !this.f13595g.l(frameLayout, false)) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
        } else {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
        }
    }
}
