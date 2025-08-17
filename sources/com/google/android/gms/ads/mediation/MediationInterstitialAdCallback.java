package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

public interface MediationInterstitialAdCallback extends MediationAdCallback {
    void onAdFailedToShow(AdError adError);

    @Deprecated
    void onAdFailedToShow(String str);

    void onAdLeftApplication();
}
