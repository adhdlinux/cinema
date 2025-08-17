package com.startapp.sdk.adsbase.adlisteners;

import com.startapp.sdk.adsbase.Ad;

public interface AdEventListener {
    void onFailedToReceiveAd(Ad ad);

    void onReceiveAd(Ad ad);
}
