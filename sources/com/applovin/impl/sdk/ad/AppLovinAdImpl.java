package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

public abstract class AppLovinAdImpl extends AppLovinAdBase implements AppLovinAd {

    /* renamed from: a  reason: collision with root package name */
    private d f15075a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f15076b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    private f f15077c;
    protected final b source;

    protected AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        super(jSONObject, jSONObject2, mVar);
        this.source = bVar;
    }

    public boolean equals(Object obj) {
        AppLovinAd b2;
        if ((obj instanceof f) && (b2 = ((f) obj).b()) != null) {
            obj = b2;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber();
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(getJsonObjectFromAdObject(Utils.KEY_AD_VALUES, new JSONObject()), str, str2);
    }

    public d getAdZone() {
        d dVar = this.f15075a;
        if (dVar != null) {
            if (dVar.c() != null && this.f15075a.d() != null) {
                return this.f15075a;
            }
            if (getSize() == null && getType() == null) {
                return this.f15075a;
            }
        }
        d a2 = d.a(getSize(), getType(), getStringFromFullResponse("zone_id", (String) null));
        this.f15075a = a2;
        return a2;
    }

    public f getDummyAd() {
        return this.f15077c;
    }

    public Bundle getMAXAdValues() {
        return this.f15076b;
    }

    public abstract JSONObject getOriginalFullResponse();

    public String getRawFullResponse() {
        String jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse.toString();
        }
        return jSONObject;
    }

    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", (String) null));
    }

    public b getSource() {
        return this.source;
    }

    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", (String) null));
    }

    public String getZoneId() {
        if (getAdZone().e()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", (String) null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        if (!v.a()) {
            return false;
        }
        this.sdk.A().e("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(f fVar) {
        this.f15077c = fVar;
    }

    public void setHasShown(boolean z2) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z2);
            }
        } catch (Throwable unused) {
        }
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.f15076b);
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", Boolean.FALSE);
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", source=" + getSource() + ", zoneId=\"" + getZoneId() + "\"" + '}';
    }
}
