package com.chartboost.sdk.events;

import com.chartboost.sdk.ads.Ad;

public interface AdEvent {
    Ad getAd();

    String getAdID();
}
