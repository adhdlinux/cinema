package com.vungle.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignaledAd;
import kotlin.jvm.internal.Intrinsics;

public abstract class BaseFullscreenAd extends BaseAd implements FullscreenAd {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseFullscreenAd(Context context, String str, AdConfig adConfig) {
        super(context, str, adConfig);
        Intrinsics.f(context, "context");
        Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
        Intrinsics.f(adConfig, "adConfig");
    }

    public void load(String str) {
        setSignaledAd$vungle_ads_release(getSignalManager$vungle_ads_release().getSignaledAd(getPlacementId()));
        super.load(str);
    }

    public void onAdLoaded$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.f(adPayload, "advertisement");
        super.onAdLoaded$vungle_ads_release(adPayload);
        SignaledAd signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release != null) {
            signaledAd$vungle_ads_release.setAdAvailabilityCallbackTime(System.currentTimeMillis());
        }
    }

    public void play(Context context) {
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.PLAY_AD_API), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        getResponseToShowMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, getResponseToShowMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        getShowToFailMetric$vungle_ads_release().markStart();
        getShowToCloseMetric$vungle_ads_release().markStart();
        SignaledAd signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release != null) {
            signaledAd$vungle_ads_release.setPlayAdTime(System.currentTimeMillis());
            signaledAd$vungle_ads_release.calculateTimeBetweenAdAvailabilityAndPlayAd();
            getSignalManager$vungle_ads_release().registerSignaledAd(context, signaledAd$vungle_ads_release);
        }
        getAdInternal$vungle_ads_release().play(context, new BaseFullscreenAd$play$2(this));
    }
}
