package com.chartboost.sdk.events;

import com.chartboost.sdk.ads.Ad;
import kotlin.jvm.internal.Intrinsics;

public final class RewardEvent implements AdEvent {
    private final Ad ad;
    private final String adID;
    private final int reward;

    public RewardEvent(String str, Ad ad2, int i2) {
        Intrinsics.f(ad2, "ad");
        this.adID = str;
        this.ad = ad2;
        this.reward = i2;
    }

    public Ad getAd() {
        return this.ad;
    }

    public String getAdID() {
        return this.adID;
    }

    public final int getReward() {
        return this.reward;
    }
}
