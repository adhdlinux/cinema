package com.applovin.impl.sdk.ad;

import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;
import org.json.JSONObject;

public final class f extends AppLovinAdImpl {

    /* renamed from: a  reason: collision with root package name */
    private AppLovinAd f15132a;

    /* renamed from: b  reason: collision with root package name */
    private final d f15133b;

    public f(d dVar, m mVar) {
        super(new JSONObject(), new JSONObject(), b.UNKNOWN, mVar);
        this.f15133b = dVar;
    }

    private AppLovinAd c() {
        return (AppLovinAd) this.sdk.Z().c(this.f15133b);
    }

    private String d() {
        d adZone = getAdZone();
        if (adZone == null || adZone.e()) {
            return null;
        }
        return adZone.a();
    }

    public AppLovinAd a() {
        return this.f15132a;
    }

    public void a(AppLovinAd appLovinAd) {
        this.f15132a = appLovinAd;
    }

    public AppLovinAd b() {
        AppLovinAd appLovinAd = this.f15132a;
        return appLovinAd != null ? appLovinAd : c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        AppLovinAd b2 = b();
        return b2 != null ? b2.equals(obj) : super.equals(obj);
    }

    public long getAdIdNumber() {
        AppLovinAd b2 = b();
        if (b2 != null) {
            return b2.getAdIdNumber();
        }
        return 0;
    }

    public d getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) b();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.f15133b;
    }

    public long getCreatedAtMillis() {
        AppLovinAd b2 = b();
        if (b2 instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b2).getCreatedAtMillis();
        }
        return 0;
    }

    public String getOpenMeasurementContentUrl() {
        return null;
    }

    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    public JSONObject getOriginalFullResponse() {
        AppLovinAd b2 = b();
        if (b2 instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b2).getOriginalFullResponse();
        }
        return null;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().c();
    }

    public b getSource() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) b();
        return appLovinAdImpl != null ? appLovinAdImpl.getSource() : b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        return getAdZone().d();
    }

    public String getZoneId() {
        if (this.f15133b.e()) {
            return null;
        }
        return this.f15133b.a();
    }

    public int hashCode() {
        AppLovinAd b2 = b();
        return b2 != null ? b2.hashCode() : super.hashCode();
    }

    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    public boolean isVideoAd() {
        AppLovinAd b2 = b();
        return b2 != null && b2.isVideoAd();
    }

    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + d() + '\'' + '}';
    }
}
