package com.vungle.ads;

import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.jvm.internal.Intrinsics;

public final class BaseFullscreenAd$play$2 implements AdPlayCallback {
    final /* synthetic */ BaseFullscreenAd this$0;

    BaseFullscreenAd$play$2(BaseFullscreenAd baseFullscreenAd) {
        this.this$0 = baseFullscreenAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdClick$lambda-3  reason: not valid java name */
    public static final void m129onAdClick$lambda3(BaseFullscreenAd baseFullscreenAd) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdClicked(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdEnd$lambda-2  reason: not valid java name */
    public static final void m130onAdEnd$lambda2(BaseFullscreenAd baseFullscreenAd) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdEnd(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdImpression$lambda-1  reason: not valid java name */
    public static final void m131onAdImpression$lambda1(BaseFullscreenAd baseFullscreenAd) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdImpression(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdLeftApplication$lambda-5  reason: not valid java name */
    public static final void m132onAdLeftApplication$lambda5(BaseFullscreenAd baseFullscreenAd) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdLeftApplication(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdRewarded$lambda-4  reason: not valid java name */
    public static final void m133onAdRewarded$lambda4(BaseFullscreenAd baseFullscreenAd) {
        RewardedAdListener rewardedAdListener;
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener instanceof RewardedAdListener) {
            rewardedAdListener = (RewardedAdListener) adListener;
        } else {
            rewardedAdListener = null;
        }
        if (rewardedAdListener != null) {
            rewardedAdListener.onAdRewarded(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdStart$lambda-0  reason: not valid java name */
    public static final void m134onAdStart$lambda0(BaseFullscreenAd baseFullscreenAd) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdStart(baseFullscreenAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-6  reason: not valid java name */
    public static final void m135onFailure$lambda6(BaseFullscreenAd baseFullscreenAd, VungleError vungleError) {
        Intrinsics.f(baseFullscreenAd, "this$0");
        Intrinsics.f(vungleError, "$error");
        BaseAdListener adListener = baseFullscreenAd.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(baseFullscreenAd, vungleError);
        }
    }

    public void onAdClick(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new p(this.this$0));
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getDisplayToClickMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
    }

    public void onAdEnd(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new q(this.this$0));
        this.this$0.getShowToCloseMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getShowToCloseMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
    }

    public void onAdImpression(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new o(this.this$0));
        this.this$0.getPresentToDisplayMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getPresentToDisplayMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markStart();
    }

    public void onAdLeftApplication(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new s(this.this$0));
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getLeaveApplicationMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
    }

    public void onAdRewarded(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new n(this.this$0));
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getRewardedMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
    }

    public void onAdStart(String str) {
        this.this$0.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
        this.this$0.getPresentToDisplayMetric$vungle_ads_release().markStart();
        ThreadUtil.INSTANCE.runOnUiThread(new r(this.this$0));
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        ThreadUtil.INSTANCE.runOnUiThread(new t(this.this$0, vungleError));
        this.this$0.getShowToFailMetric$vungle_ads_release().markEnd();
        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this.this$0.getShowToFailMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), String.valueOf(vungleError.getCode()));
    }
}
