package com.chartboost.sdk.events;

import com.chartboost.sdk.ads.Ad;
import kotlin.jvm.internal.Intrinsics;

public final class ShowEvent implements AdEvent {
    private final Ad ad;
    private final String adID;

    public ShowEvent(String str, Ad ad2) {
        Intrinsics.f(ad2, "ad");
        this.adID = str;
        this.ad = ad2;
    }

    public Ad getAd() {
        return this.ad;
    }

    public String getAdID() {
        return this.adID;
    }
}
