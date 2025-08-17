package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

@Deprecated
public interface CustomEventNativeListener extends CustomEventListener {
    void onAdImpression();

    void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper);
}
