package com.applovin.impl.sdk.nativeAd;

public interface AppLovinNativeAdLoadListener {
    void onNativeAdLoadFailed(int i2);

    void onNativeAdLoaded(AppLovinNativeAd appLovinNativeAd);
}
