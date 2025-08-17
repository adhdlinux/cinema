package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class j {
    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdViewEventListener.this.adOpenedFullscreen(j.b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdViewEventListener.this.adFailedToDisplay(j.b(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinNativeAdEventListener appLovinNativeAdEventListener, final AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinNativeAdEventListener.this.onNativeAdClicked(appLovinNativeAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, final int i2) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinNativeAdLoadListener.this.onNativeAdLoadFailed(i2);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd) {
        a(maxAdListener, maxAd, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        a(maxAdListener, maxAd, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdDisplayFailed(maxAd, maxError);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        a(maxAdListener, maxAd, maxReward, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) MaxAdListener.this).onUserRewarded(maxAd, maxReward);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdLoaded(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        a(maxAdListener, str, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, boolean z2) {
        if (str != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdLoadFailed(str, maxError);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        a(maxAdRevenueListener, maxAd, false);
    }

    public static void a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxAdRevenueListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdRevenueListener.this.onAdRevenuePaid(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad revenue being paid", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        a(maxAdReviewListener, str, maxAd, false);
    }

    public static void a(final MaxAdReviewListener maxAdReviewListener, final String str, final MaxAd maxAd, boolean z2) {
        if (maxAdReviewListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdReviewListener.this.onCreativeIdGenerated(str, maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify Ad Review creative id generated", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxNativeAdListener.this.onNativeAdClicked(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad being clicked", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxNativeAdView maxNativeAdView, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxNativeAdListener.this.onNativeAdLoaded(maxNativeAdView, maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad being loaded", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final String str, final MaxError maxError, boolean z2) {
        if (str != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxNativeAdListener.this.onNativeAdLoadFailed(str, maxError);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad failing to load", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdClickListener.this.adClicked(j.b(appLovinAd));
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdDisplayListener.this.adDisplayed(j.b(appLovinAd));
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof g) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    ((g) AppLovinAdDisplayListener.this).onAdDisplayFailed(str);
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdRewardListener.this.validationRequestFailed(j.b(appLovinAd), i2);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdRewardListener.this.userRewardVerified(j.b(appLovinAd), map);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdVideoPlaybackListener.this.videoPlaybackBegan(j.b(appLovinAd));
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d2, boolean z2) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
            final AppLovinAd appLovinAd2 = appLovinAd;
            final double d3 = d2;
            final boolean z3 = z2;
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdVideoPlaybackListener.this.videoPlaybackEnded(j.b(appLovinAd2), d3, z3);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinPostbackListener.this.onPostbackSuccess(str);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
                        }
                    }
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i2) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinPostbackListener.this.onPostbackFailure(str, i2);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i2 + "):", th);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static AppLovinAd b(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    public static void b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdViewEventListener.this.adClosedFullscreen(j.b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
                        }
                    }
                }
            });
        }
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd) {
        b(maxAdListener, maxAd, false);
    }

    public static void b(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdDisplayed(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                        }
                    }
                }
            });
        }
    }

    public static void b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdDisplayListener.this.adHidden(j.b(appLovinAd));
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                        }
                    }
                }
            });
        }
    }

    public static void b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdRewardListener.this.userOverQuota(j.b(appLovinAd), map);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
                        }
                    }
                }
            });
        }
    }

    public static void c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdViewEventListener.this.adLeftApplication(j.b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
                        }
                    }
                }
            });
        }
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd) {
        c(maxAdListener, maxAd, false);
    }

    public static void c(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdHidden(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                        }
                    }
                }
            });
        }
    }

    public static void c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        AppLovinAdRewardListener.this.userRewardRejected(j.b(appLovinAd), map);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
                        }
                    }
                }
            });
        }
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd) {
        d(maxAdListener, maxAd, false);
    }

    public static void d(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        MaxAdListener.this.onAdClicked(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                        }
                    }
                }
            });
        }
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd) {
        e(maxAdListener, maxAd, false);
    }

    public static void e(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) MaxAdListener.this).onRewardedVideoStarted(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", th);
                        }
                    }
                }
            });
        }
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd) {
        f(maxAdListener, maxAd, false);
    }

    public static void f(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) MaxAdListener.this).onRewardedVideoCompleted(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", th);
                        }
                    }
                }
            });
        }
    }

    public static void g(MaxAdListener maxAdListener, MaxAd maxAd) {
        g(maxAdListener, maxAd, false);
    }

    public static void g(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) MaxAdListener.this).onAdExpanded(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", th);
                        }
                    }
                }
            });
        }
    }

    public static void h(MaxAdListener maxAdListener, MaxAd maxAd) {
        h(maxAdListener, maxAd, false);
    }

    public static void h(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) MaxAdListener.this).onAdCollapsed(maxAd);
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", th);
                        }
                    }
                }
            });
        }
    }
}
