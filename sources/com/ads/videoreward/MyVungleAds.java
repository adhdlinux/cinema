package com.ads.videoreward;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ads.videoreward.AdsBase;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.AppConfig;
import com.original.tase.utils.DeviceUtils;
import com.utils.Utils;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BannerAd;
import com.vungle.ads.BannerAdSize;
import com.vungle.ads.BannerView;
import com.vungle.ads.BaseAd;
import com.vungle.ads.BaseAdListener;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InterstitialAd;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;
import timber.log.Timber;

public class MyVungleAds extends AdsBase implements BaseAdListener {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AppConfig.AdsBean.VungleBean f13601f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public BannerAd f13602g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public InterstitialAd f13603h;

    public void f() {
        AppConfig.AdsBean.VungleBean vungleBean;
        super.f();
        final Context v2 = Utils.v();
        if (v2 != null) {
            if (DeviceUtils.b()) {
                vungleBean = GlobalVariable.c().b().getAds().getVungle_amz();
            } else {
                vungleBean = GlobalVariable.c().b().getAds().getVungle();
            }
            this.f13601f = vungleBean;
            if (vungleBean != null) {
                n(vungleBean.getEcmp());
                VungleAds.init(v2, this.f13601f.getApp_id(), new InitializationListener() {
                    public void onError(VungleError vungleError) {
                        Timber.c("Vungle SDK initialization error: %s", vungleError.getErrorMessage());
                    }

                    public void onSuccess() {
                        String placement_interstitial = MyVungleAds.this.f13601f.getPlacement_interstitial();
                        InterstitialAd unused = MyVungleAds.this.f13603h = new InterstitialAd(v2, placement_interstitial, new AdConfig());
                        MyVungleAds.this.f13603h.setAdListener(MyVungleAds.this);
                        MyVungleAds.this.f13603h.load((String) null);
                        BannerAd unused2 = MyVungleAds.this.f13602g = new BannerAd(v2, placement_interstitial, BannerAdSize.BANNER);
                        MyVungleAds.this.f13602g.setAdListener(MyVungleAds.this);
                        MyVungleAds.this.f13602g.load((String) null);
                        Timber.b("Vungle SDK initialized successfully.", new Object[0]);
                    }
                });
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        BannerView bannerView;
        if (viewGroup == null || this.f13601f == null) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
            return;
        }
        BannerAd bannerAd = this.f13602g;
        if (bannerAd != null) {
            bannerView = bannerAd.getBannerView();
        } else {
            bannerView = null;
        }
        if (bannerView == null) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
            return;
        }
        bannerView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 1));
        viewGroup.addView(bannerView);
    }

    public void onAdClicked(BaseAd baseAd) {
    }

    public void onAdEnd(BaseAd baseAd) {
    }

    public void onAdFailedToLoad(BaseAd baseAd, VungleError vungleError) {
    }

    public void onAdFailedToPlay(BaseAd baseAd, VungleError vungleError) {
    }

    public void onAdImpression(BaseAd baseAd) {
    }

    public void onAdLeftApplication(BaseAd baseAd) {
    }

    public void onAdLoaded(BaseAd baseAd) {
    }

    public void onAdStart(BaseAd baseAd) {
        if (this.f13601f != null) {
            String placementId = baseAd.getPlacementId();
            if (placementId.equals(this.f13601f.getPlacement_interstitial())) {
                this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
            } else if (placementId.equals(this.f13601f.getPlacement_ref_native_id())) {
                this.f13551e.b(this, AdsBase.AdBaseType.NATIVE, AdsBase.AdsStatus.SHOWED);
            } else if (placementId.equals(this.f13601f.getPlacement_ref_banner_id())) {
                this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
            }
            Timber.f("Ad started: %s", placementId);
        }
    }

    public void p(Activity activity) {
        InterstitialAd interstitialAd;
        if (activity == null || (interstitialAd = this.f13603h) == null || !interstitialAd.canPlayAd().booleanValue()) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
        } else {
            this.f13603h.play(activity);
        }
    }
}
