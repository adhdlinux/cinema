package com.facebook.ads.internal.protocol;

import android.text.TextUtils;
import com.vungle.ads.internal.Constants;
import java.util.Locale;

public enum AdPlacementType {
    BANNER("banner"),
    INSTREAM("instream"),
    INTERSTITIAL(Constants.PLACEMENT_TYPE_INTERSTITIAL),
    NATIVE("native"),
    NATIVE_BANNER("native_banner"),
    REWARDED_VIDEO("rewarded_video"),
    UNKNOWN("unknown");
    

    /* renamed from: a  reason: collision with root package name */
    private String f20542a;

    private AdPlacementType(String str) {
        this.f20542a = str;
    }

    public static AdPlacementType fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f20542a;
    }
}
