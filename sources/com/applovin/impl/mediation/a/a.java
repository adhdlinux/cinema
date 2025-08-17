package com.applovin.impl.mediation.a;

import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class a extends f implements MaxAd {

    /* renamed from: a  reason: collision with root package name */
    protected g f14220a;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14221c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private MaxAdWaterfallInfo f14222d;

    /* renamed from: e  reason: collision with root package name */
    private String f14223e;

    protected a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, m mVar) {
        super(map, jSONObject, jSONObject2, mVar);
        this.f14220a = gVar;
    }

    public static a a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", (String) null);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(string);
        if (formatFromString.isAdViewAd()) {
            return new b(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new d(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString.isFullscreenAd()) {
            return new c(map, jSONObject, jSONObject2, mVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    private long u() {
        return b("load_started_time_ms", 0);
    }

    public abstract a a(g gVar);

    public String a() {
        return this.f14223e;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("creative_id") && !b("creative_id")) {
                c("creative_id", BundleUtils.getString("creative_id", bundle));
            }
            if (bundle.containsKey("ad_width") && !b("ad_width") && bundle.containsKey("ad_height") && !b("ad_height")) {
                int i2 = BundleUtils.getInt("ad_width", bundle);
                int i3 = BundleUtils.getInt("ad_height", bundle);
                c("ad_width", i2);
                c("ad_height", i3);
            }
        }
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.f14222d = maxAdWaterfallInfo;
    }

    public void a(String str) {
        this.f14223e = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            JSONObject b2 = b();
            JsonUtils.putAll(b2, jSONObject);
            a(Utils.KEY_AD_VALUES, (Object) b2);
        }
    }

    public JSONObject b() {
        return a(Utils.KEY_AD_VALUES, new JSONObject());
    }

    public JSONObject c() {
        return a("revenue_parameters", new JSONObject());
    }

    public String d() {
        return JsonUtils.getString(c(), "revenue_event", "");
    }

    public boolean e() {
        g gVar = this.f14220a;
        return gVar != null && gVar.f() && this.f14220a.g();
    }

    public String f() {
        return a("event_id", "");
    }

    public g g() {
        return this.f14220a;
    }

    public String getAdReviewCreativeId() {
        return this.f14230b.B().a(f());
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        JSONObject b2 = b();
        if (b2.has(str)) {
            return JsonUtils.getString(b2, str, str2);
        }
        Bundle U = U();
        return U.containsKey(str) ? U.getString(str) : b(str, str2);
    }

    public String getCreativeId() {
        return b("creative_id", (String) null);
    }

    public String getDspId() {
        return b("dsp_id", (String) null);
    }

    public String getDspName() {
        return b("dsp_name", (String) null);
    }

    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(b("ad_format", a("ad_format", (String) null)));
    }

    public MaxNativeAd getNativeAd() {
        return null;
    }

    public String getNetworkName() {
        return b("network_name", "");
    }

    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(l());
    }

    public double getRevenue() {
        return JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
    }

    public String getRevenuePrecision() {
        return JsonUtils.getString(a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public AppLovinSdkUtils.Size getSize() {
        int b2 = b("ad_width", -3);
        int b3 = b("ad_height", -3);
        return (b2 == -3 || b3 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(b2, b3);
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return this.f14222d;
    }

    public Bundle h() {
        JSONObject jSONObject;
        if (b("credentials")) {
            jSONObject = a("credentials", new JSONObject());
        } else {
            jSONObject = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObject, "placement_id", l());
        }
        return JsonUtils.toBundle(jSONObject);
    }

    public String i() {
        return b("bid_response", (String) null);
    }

    public long j() {
        return b("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1, U()));
    }

    public boolean k() {
        return b("is_js_tag_ad", Boolean.FALSE).booleanValue();
    }

    public String l() {
        return b("third_party_ad_placement_id", (String) null);
    }

    public String m() {
        return a("waterfall_name", "");
    }

    public String n() {
        return a("waterfall_test_name", "");
    }

    public long o() {
        if (u() > 0) {
            return q() - u();
        }
        return -1;
    }

    public void p() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public long q() {
        return b("load_completed_time_ms", 0);
    }

    public void r() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public AtomicBoolean s() {
        return this.f14221c;
    }

    public void t() {
        this.f14220a = null;
        this.f14222d = null;
    }

    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + l() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
