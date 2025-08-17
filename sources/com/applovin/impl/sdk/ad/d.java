package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, d> f15097a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15098b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f15099c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15100d;

    /* renamed from: e  reason: collision with root package name */
    private AppLovinAdSize f15101e;

    /* renamed from: f  reason: collision with root package name */
    private AppLovinAdType f15102f;

    private d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.f15101e = appLovinAdSize;
            this.f15102f = appLovinAdType;
            if (StringUtils.isValidString(str)) {
                str2 = str.trim();
            } else {
                str2 = appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel();
            }
            this.f15100d = str2.toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return a(appLovinAdSize, appLovinAdType, (String) null);
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        d dVar = new d(appLovinAdSize, appLovinAdType, str);
        synchronized (f15098b) {
            String str2 = dVar.f15100d;
            Map<String, d> map = f15097a;
            if (map.containsKey(str2)) {
                dVar = map.get(str2);
            } else {
                map.put(str2, dVar);
            }
        }
        return dVar;
    }

    public static d a(String str) {
        return a((AppLovinAdSize) null, (AppLovinAdType) null, str);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f15098b) {
                d dVar = f15097a.get(JsonUtils.getString(jSONObject, "zone_id", ""));
                if (dVar != null) {
                    dVar.f15101e = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                    dVar.f15102f = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", ""));
                }
            }
        }
    }

    public static d b(String str) {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    public static Collection<d> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(6);
        Collections.addAll(linkedHashSet, new d[]{g(), h(), i(), j(), k(), l()});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static d g() {
        return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    public static d h() {
        return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    public static d i() {
        return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    public static d j() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    public static d k() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    public static d l() {
        return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    public String a() {
        return this.f15100d;
    }

    public MaxAdFormat b() {
        AppLovinAdSize c2 = c();
        if (c2 == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (c2 == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (c2 == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (c2 == AppLovinAdSize.CROSS_PROMO) {
            return MaxAdFormat.CROSS_PROMO;
        }
        if (c2 == AppLovinAdSize.INTERSTITIAL) {
            if (d() == AppLovinAdType.REGULAR) {
                return MaxAdFormat.INTERSTITIAL;
            }
            if (d() == AppLovinAdType.INCENTIVIZED) {
                return MaxAdFormat.REWARDED;
            }
            if (d() == AppLovinAdType.AUTO_INCENTIVIZED) {
                return MaxAdFormat.REWARDED_INTERSTITIAL;
            }
            return null;
        } else if (c2 == AppLovinAdSize.NATIVE) {
            return MaxAdFormat.NATIVE;
        } else {
            return null;
        }
    }

    public AppLovinAdSize c() {
        if (this.f15101e == null && JsonUtils.valueExists(this.f15099c, "ad_size")) {
            this.f15101e = AppLovinAdSize.fromString(JsonUtils.getString(this.f15099c, "ad_size", (String) null));
        }
        return this.f15101e;
    }

    public AppLovinAdType d() {
        if (this.f15102f == null && JsonUtils.valueExists(this.f15099c, "ad_type")) {
            this.f15102f = AppLovinAdType.fromString(JsonUtils.getString(this.f15099c, "ad_type", (String) null));
        }
        return this.f15102f;
    }

    public boolean e() {
        return f().contains(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f15100d.equalsIgnoreCase(((d) obj).f15100d);
    }

    public int hashCode() {
        return this.f15100d.hashCode();
    }

    public String toString() {
        return "AdZone{id=" + this.f15100d + ", zoneObject=" + this.f15099c + '}';
    }
}
