package com.chartboost.sdk.impl;

public enum h8 {
    UNKNOWN(0, "Unknown"),
    ETHERNET(1, "Ethernet"),
    WIFI(2, "WIFI"),
    CELLULAR_UNKNOWN(3, "Cellular_Unknown"),
    CELLULAR_2G(4, "Cellular_2G"),
    CELLULAR_3G(5, "Cellular_3G"),
    CELLULAR_4G(6, "Cellular_4G"),
    CELLULAR_5G(7, "Cellular_5G");
    

    /* renamed from: b  reason: collision with root package name */
    public final int f17854b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17855c;

    /* access modifiers changed from: public */
    h8(int i2, String str) {
        this.f17854b = i2;
        this.f17855c = str;
    }

    public final String b() {
        return this.f17855c;
    }

    public final int c() {
        return this.f17854b;
    }
}
