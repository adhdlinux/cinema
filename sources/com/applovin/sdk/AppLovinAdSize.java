package com.applovin.sdk;

import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Locale;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, AdPreferences.TYPE_BANNER);
    public static final AppLovinAdSize CROSS_PROMO = new AppLovinAdSize(-1, -1, "XPROMO");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(300, 250, "MREC");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize(-1, -1, "NATIVE");
    public static final int SPAN = -1;

    /* renamed from: a  reason: collision with root package name */
    private final String f16042a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16043b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16044c;

    private AppLovinAdSize(int i2, int i3, String str) {
        this.f16043b = i2;
        this.f16044c = i3;
        this.f16042a = str;
    }

    public static AppLovinAdSize fromString(String str) {
        if (AdPreferences.TYPE_BANNER.equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("XPROMO".equalsIgnoreCase(str)) {
            return CROSS_PROMO;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }

    public int getHeight() {
        return this.f16044c;
    }

    public String getLabel() {
        return this.f16042a.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f16043b;
    }

    public String toString() {
        return getLabel();
    }
}
