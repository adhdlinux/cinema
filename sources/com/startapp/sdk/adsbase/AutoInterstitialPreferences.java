package com.startapp.sdk.adsbase;

import java.io.Serializable;

public class AutoInterstitialPreferences implements Serializable {
    private static final long serialVersionUID = 1;
    private int activitiesBetweenAds;
    private int secondsBetweenAds;

    public AutoInterstitialPreferences() {
        setActivitiesBetweenAds(AdsCommonMetaData.k().f());
        setSecondsBetweenAds(AdsCommonMetaData.k().g());
    }

    public int getActivitiesBetweenAds() {
        return this.activitiesBetweenAds;
    }

    public int getSecondsBetweenAds() {
        return this.secondsBetweenAds;
    }

    public AutoInterstitialPreferences setActivitiesBetweenAds(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        this.activitiesBetweenAds = i2;
        return this;
    }

    public AutoInterstitialPreferences setSecondsBetweenAds(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.secondsBetweenAds = i2;
        return this;
    }

    public String toString() {
        return "AutoInterstitialPreferences [activitiesBetweenAds=" + this.activitiesBetweenAds + ", secondsBetweenAds=" + this.secondsBetweenAds + "]";
    }
}
