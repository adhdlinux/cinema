package com.applovin.impl.mediation.c;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.u;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxErrorCode;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f14395a;

    /* renamed from: c  reason: collision with root package name */
    private final MaxAdFormat f14396c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f14397d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Object> f14398e;

    /* renamed from: f  reason: collision with root package name */
    private final JSONArray f14399f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f14400g;

    /* renamed from: h  reason: collision with root package name */
    private final a.C0011a f14401h;

    public c(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, JSONArray jSONArray, Context context, m mVar, a.C0011a aVar) {
        super("TaskFetchMediatedAd " + str, mVar);
        this.f14395a = str;
        this.f14396c = maxAdFormat;
        this.f14397d = map;
        this.f14398e = map2;
        this.f14399f = jSONArray;
        this.f14400g = context;
        this.f14401h = aVar;
    }

    private String a() {
        return b.a(this.f15333b);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (v.a()) {
            d("Unable to fetch " + this.f14395a + " ad: server returned " + i2);
        }
        if (i2 == -800) {
            this.f15333b.T().a(f.f15316o);
        }
        j.a((MaxAdListener) this.f14401h, this.f14395a, (MaxError) i2 == -1009 ? new MaxErrorImpl(-1009, str) : i2 == -1001 ? new MaxErrorImpl(-1001, str) : StringUtils.isValidString(str) ? new MaxErrorImpl(MaxErrorCode.NETWORK_ERROR, str) : new MaxErrorImpl(-1));
    }

    private void a(g gVar) {
        f fVar = f.f15304c;
        long b2 = gVar.b(fVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b2 > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.dk)).intValue())) {
            gVar.b(fVar, currentTimeMillis);
            gVar.c(f.f15305d);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            h.d(jSONObject, this.f15333b);
            h.c(jSONObject, this.f15333b);
            h.e(jSONObject, this.f15333b);
            h.f(jSONObject, this.f15333b);
            b.a(jSONObject, this.f15333b);
            b.b(jSONObject, this.f15333b);
            com.applovin.impl.sdk.f.a(this.f15333b);
            if (this.f14396c != MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", (String) null)) && v.a()) {
                v.i(e(), "Ad format requested does not match ad unit id's format.");
            }
            this.f15333b.S().a((com.applovin.impl.sdk.e.a) b(jSONObject));
        } catch (Throwable th) {
            if (v.a()) {
                a("Unable to process mediated ad response", th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private e b(JSONObject jSONObject) {
        return new e(this.f14395a, this.f14396c, this.f14397d, jSONObject, this.f14400g, this.f15333b, this.f14401h);
    }

    private String b() {
        return b.b(this.f15333b);
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("AppLovin-Ad-Unit-Id", this.f14395a);
        hashMap.put("AppLovin-Ad-Format", this.f14396c.getLabel());
        return hashMap;
    }

    private void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f15333b.C().c()));
            jSONObject2.put("installed", com.applovin.impl.mediation.d.c.a(this.f15333b));
            jSONObject2.put("initialized", this.f15333b.D().c());
            jSONObject2.put("initialized_classnames", new JSONArray(this.f15333b.D().b()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f15333b.C().a()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f15333b.C().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e2) {
            if (v.a()) {
                a("Failed to populate adapter classNames", e2);
            }
            throw new RuntimeException("Failed to populate classNames: " + e2);
        }
    }

    private void d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f14399f;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f14395a);
        jSONObject2.put("ad_format", this.f14396c.getLabel());
        HashMap hashMap = new HashMap(this.f14398e);
        com.applovin.impl.mediation.a.a a2 = this.f15333b.F().a(this.f14395a);
        if (a2 != null) {
            hashMap.put("previous_winning_network", a2.L());
            hashMap.put("previous_winning_network_name", a2.getNetworkName());
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(hashMap));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f15333b.E().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData != null && Utils.isDspDemoApp(this.f15333b.L())) {
            JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f15333b.p().getExtraParameters()));
    }

    private JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f15333b.V().a((Map<String, String>) null, false, true));
        e(jSONObject);
        d(jSONObject);
        c(jSONObject);
        f(jSONObject);
        g(jSONObject);
        return jSONObject;
    }

    public void run() {
        if (v.a()) {
            a("Fetching next ad for ad unit id: " + this.f14395a + " and format: " + this.f14396c);
        }
        if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.dF)).booleanValue() && Utils.isVPNConnected() && v.a()) {
            a("User is connected to a VPN");
        }
        g T = this.f15333b.T();
        T.a(f.f15315n);
        f fVar = f.f15304c;
        if (T.b(fVar) == 0) {
            T.b(fVar, System.currentTimeMillis());
        }
        try {
            JSONObject h2 = h();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (!((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ep)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15333b.z());
            }
            if (this.f15333b.J().a()) {
                hashMap.put("test_mode", "1");
            }
            String c2 = this.f15333b.J().c();
            if (StringUtils.isValidString(c2)) {
                hashMap.put("filter_ad_network", c2);
                if (!this.f15333b.J().a()) {
                    hashMap.put("fhkZsVqYC7", "1");
                }
                if (this.f15333b.J().b()) {
                    hashMap.put("force_ad_network", c2);
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(c());
            a(T);
            AnonymousClass1 r12 = new u<JSONObject>(com.applovin.impl.sdk.network.c.a(this.f15333b).b("POST").b((Map<String, String>) hashMap2).a(a()).c(b()).a((Map<String, String>) hashMap).a(h2).d(((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.a.U)).booleanValue()).a(new JSONObject()).b(((Long) this.f15333b.a(com.applovin.impl.sdk.c.a.f15184f)).intValue()).a(((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.cS)).intValue()).c(((Long) this.f15333b.a(com.applovin.impl.sdk.c.a.f15183e)).intValue()).a(), this.f15333b) {
                public void a(int i2, String str, JSONObject jSONObject) {
                    c.this.a(i2, str);
                }

                public void a(JSONObject jSONObject, int i2) {
                    if (i2 == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f15438d.a());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f15438d.b());
                        c.this.a(jSONObject);
                        return;
                    }
                    c.this.a(i2, (String) null);
                }
            };
            r12.a(com.applovin.impl.sdk.c.a.f15181c);
            r12.b(com.applovin.impl.sdk.c.a.f15182d);
            this.f15333b.S().a((com.applovin.impl.sdk.e.a) r12);
        } catch (Throwable th) {
            if (v.a()) {
                a("Unable to fetch ad " + this.f14395a, th);
            }
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
