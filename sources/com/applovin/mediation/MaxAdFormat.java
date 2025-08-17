package com.applovin.mediation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdkUtils;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class MaxAdFormat {
    public static final MaxAdFormat BANNER = new MaxAdFormat(AdPreferences.TYPE_BANNER, "Banner");
    public static final MaxAdFormat CROSS_PROMO = new MaxAdFormat("XPROMO", "Cross Promo");
    public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER", "Interstitial");
    public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER", "Leader");
    public static final MaxAdFormat MREC = new MaxAdFormat("MREC", "MREC");
    public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE", "Native");
    public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED", "Rewarded");
    public static final MaxAdFormat REWARDED_INTERSTITIAL = new MaxAdFormat("REWARDED_INTER", "Rewarded Interstitial");

    /* renamed from: a  reason: collision with root package name */
    private final String f15958a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15959b;

    private MaxAdFormat(String str, String str2) {
        this.f15958a = str;
        this.f15959b = str2;
    }

    public static MaxAdFormat formatFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("banner")) {
            return BANNER;
        }
        if (str.equalsIgnoreCase("mrec")) {
            return MREC;
        }
        if (str.equalsIgnoreCase("xpromo")) {
            return CROSS_PROMO;
        }
        if (str.equalsIgnoreCase("native")) {
            return NATIVE;
        }
        if (str.equalsIgnoreCase("leaderboard") || str.equalsIgnoreCase("leader")) {
            return LEADER;
        }
        if (str.equalsIgnoreCase(Constants.PLACEMENT_TYPE_INTERSTITIAL) || str.equalsIgnoreCase("inter")) {
            return INTERSTITIAL;
        }
        if (str.equalsIgnoreCase(Constants.PLACEMENT_TYPE_REWARDED) || str.equalsIgnoreCase("reward")) {
            return REWARDED;
        }
        if (str.equalsIgnoreCase("rewarded_inter") || str.equalsIgnoreCase("rewarded_interstitial")) {
            return REWARDED_INTERSTITIAL;
        }
        if (v.a()) {
            v.i("AppLovinSdk", "Unknown ad format: " + str);
        }
        return null;
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(int i2, Context context) {
        return (this == BANNER || this == LEADER) ? c.a(i2, this, context) : getSize();
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(Activity activity) {
        return getAdaptiveSize(-1, activity);
    }

    @Deprecated
    public String getDisplayName() {
        return this.f15959b;
    }

    public String getLabel() {
        return this.f15958a;
    }

    public AppLovinSdkUtils.Size getSize() {
        return this == BANNER ? new AppLovinSdkUtils.Size(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50) : this == LEADER ? new AppLovinSdkUtils.Size(728, 90) : this == MREC ? new AppLovinSdkUtils.Size(300, 250) : this == CROSS_PROMO ? new AppLovinSdkUtils.Size(-1, -1) : new AppLovinSdkUtils.Size(0, 0);
    }

    public boolean isAdViewAd() {
        return this == BANNER || this == MREC || this == LEADER || this == CROSS_PROMO;
    }

    public boolean isFullscreenAd() {
        return this == INTERSTITIAL || this == REWARDED || this == REWARDED_INTERSTITIAL;
    }

    public String toString() {
        return "MaxAdFormat{label='" + this.f15958a + '\'' + '}';
    }
}
