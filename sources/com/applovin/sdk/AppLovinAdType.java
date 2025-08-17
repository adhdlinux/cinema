package com.applovin.sdk;

import java.util.Locale;

public class AppLovinAdType {
    public static final AppLovinAdType AUTO_INCENTIVIZED = new AppLovinAdType("AUTOREW");
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType NATIVE = new AppLovinAdType("NATIVE");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");

    /* renamed from: a  reason: collision with root package name */
    private final String f16045a;

    private AppLovinAdType(String str) {
        this.f16045a = str;
    }

    public static AppLovinAdType fromString(String str) {
        if ("REGULAR".equalsIgnoreCase(str)) {
            return REGULAR;
        }
        if ("VIDEOA".equalsIgnoreCase(str)) {
            return INCENTIVIZED;
        }
        if ("AUTOREW".equalsIgnoreCase(str)) {
            return AUTO_INCENTIVIZED;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Type: " + str);
    }

    public String getLabel() {
        return this.f16045a.toUpperCase(Locale.ENGLISH);
    }

    public String toString() {
        return getLabel();
    }
}
