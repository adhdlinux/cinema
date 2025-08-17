package com.applovin.impl.sdk.ad;

public enum b {
    UNKNOWN(0),
    APPLOVIN_PRIMARY_ZONE(1),
    APPLOVIN_CUSTOM_ZONE(2),
    APPLOVIN_MULTIZONE(3),
    REGULAR_AD_TOKEN(4),
    DECODED_AD_TOKEN_JSON(5);
    

    /* renamed from: g  reason: collision with root package name */
    private final int f15089g;

    private b(int i2) {
        this.f15089g = i2;
    }

    public static b a(int i2) {
        return i2 == 1 ? APPLOVIN_PRIMARY_ZONE : i2 == 2 ? APPLOVIN_CUSTOM_ZONE : i2 == 3 ? APPLOVIN_MULTIZONE : i2 == 4 ? REGULAR_AD_TOKEN : i2 == 5 ? DECODED_AD_TOKEN_JSON : UNKNOWN;
    }

    public int a() {
        return this.f15089g;
    }
}
