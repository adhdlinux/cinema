package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;

@Deprecated
public interface CustomEventListener {
    void onAdClicked();

    void onAdClosed();

    @Deprecated
    void onAdFailedToLoad(int i2);

    void onAdFailedToLoad(AdError adError);

    void onAdLeftApplication();

    void onAdOpened();
}
