package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxNativeAdLoader {

    /* renamed from: a  reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f15985a;

    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f15985a = new MaxNativeAdLoaderImpl(str, appLovinSdk.coreSdk);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public void destroy() {
        this.f15985a.logApiCall("destroy()");
        this.f15985a.destroy();
    }

    public void destroy(MaxAd maxAd) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f15985a.destroy(maxAd);
    }

    public String getAdUnitId() {
        return this.f15985a.getAdUnitId();
    }

    public String getPlacement() {
        this.f15985a.logApiCall("getPlacement()");
        return this.f15985a.getPlacement();
    }

    public void loadAd() {
        loadAd((MaxNativeAdView) null);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f15985a.loadAd(maxNativeAdView);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.f15985a.render(maxNativeAdView, maxAd);
    }

    public void setCustomData(String str) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setCustomData(value=" + str + ")");
        this.f15985a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f15985a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f15985a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f15985a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setPlacement(placement=" + str + ")");
        this.f15985a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.f15985a;
        maxNativeAdLoaderImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f15985a.setRevenueListener(maxAdRevenueListener);
    }
}
