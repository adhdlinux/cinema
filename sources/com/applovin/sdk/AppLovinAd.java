package com.applovin.sdk;

public interface AppLovinAd {
    long getAdIdNumber();

    String getAdValue(String str);

    String getAdValue(String str, String str2);

    AppLovinAdSize getSize();

    AppLovinAdType getType();

    String getZoneId();

    boolean isVideoAd();
}
