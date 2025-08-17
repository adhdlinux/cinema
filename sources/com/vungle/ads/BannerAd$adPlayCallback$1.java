package com.vungle.ads;

import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.jvm.internal.Intrinsics;

public final class BannerAd$adPlayCallback$1 implements AdPlayCallback {
    final /* synthetic */ BannerAd this$0;

    BannerAd$adPlayCallback$1(BannerAd bannerAd) {
        this.this$0 = bannerAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdClick$lambda-3  reason: not valid java name */
    public static final void m118onAdClick$lambda3(BannerAd bannerAd) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdClicked(bannerAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdEnd$lambda-2  reason: not valid java name */
    public static final void m119onAdEnd$lambda2(BannerAd bannerAd) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdEnd(bannerAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdImpression$lambda-1  reason: not valid java name */
    public static final void m120onAdImpression$lambda1(BannerAd bannerAd) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdImpression(bannerAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdLeftApplication$lambda-4  reason: not valid java name */
    public static final void m121onAdLeftApplication$lambda4(BannerAd bannerAd) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdLeftApplication(bannerAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdStart$lambda-0  reason: not valid java name */
    public static final void m122onAdStart$lambda0(BannerAd bannerAd) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdStart(bannerAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-5  reason: not valid java name */
    public static final void m123onFailure$lambda5(BannerAd bannerAd, VungleError vungleError) {
        Intrinsics.f(bannerAd, "this$0");
        Intrinsics.f(vungleError, "$error");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(bannerAd, vungleError);
        }
    }

    public void onAdClick(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new f(this.this$0));
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getDisplayToClickMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
    }

    public void onAdEnd(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new h(this.this$0));
    }

    public void onAdImpression(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new i(this.this$0));
        this.this$0.getPresentToDisplayMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getPresentToDisplayMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markStart();
    }

    public void onAdLeftApplication(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new g(this.this$0));
    }

    public void onAdRewarded(String str) {
    }

    public void onAdStart(String str) {
        this.this$0.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
        this.this$0.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        this.this$0.getPresentToDisplayMetric$vungle_ads_release().markStart();
        ThreadUtil.INSTANCE.runOnUiThread(new k(this.this$0));
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        this.this$0.getShowToFailMetric$vungle_ads_release().markEnd();
        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this.this$0.getShowToFailMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), String.valueOf(vungleError.getCode()));
        ThreadUtil.INSTANCE.runOnUiThread(new j(this.this$0, vungleError));
    }
}
