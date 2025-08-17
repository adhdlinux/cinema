package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class h extends a {

    /* renamed from: a  reason: collision with root package name */
    protected final d f15363a;

    public h(d dVar, String str, m mVar) {
        super(str, mVar);
        this.f15363a = dVar;
    }

    private void a(g gVar) {
        f fVar = f.f15304c;
        long b2 = gVar.b(fVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b2 > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f15333b.a(b.dk)).intValue())) {
            gVar.b(fVar, currentTimeMillis);
            gVar.c(f.f15305d);
        }
    }

    private Map<String, String> i() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.f15363a.a());
        if (this.f15363a.c() != null) {
            hashMap.put("AppLovin-Ad-Size", this.f15363a.c().getLabel());
        }
        if (this.f15363a.d() != null) {
            hashMap.put("AppLovin-Ad-Type", this.f15363a.d().getLabel());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public abstract a a(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.f15363a.a());
        if (this.f15363a.c() != null) {
            hashMap.put("size", this.f15363a.c().getLabel());
        }
        if (this.f15363a.d() != null) {
            hashMap.put("require", this.f15363a.d().getLabel());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        if (v.a()) {
            d("Unable to fetch " + this.f15363a + " ad: server returned " + i2);
        }
        if (i2 == -800) {
            this.f15333b.T().a(f.f15309h);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.utils.h.d(jSONObject, this.f15333b);
        com.applovin.impl.sdk.utils.h.c(jSONObject, this.f15333b);
        com.applovin.impl.sdk.utils.h.e(jSONObject, this.f15333b);
        d.a(jSONObject);
        this.f15333b.S().a(a(jSONObject));
    }

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.ad.b h() {
        return this.f15363a.e() ? com.applovin.impl.sdk.ad.b.APPLOVIN_PRIMARY_ZONE : com.applovin.impl.sdk.ad.b.APPLOVIN_CUSTOM_ZONE;
    }

    public void run() {
        Map<String, String> map;
        if (v.a()) {
            a("Fetching next ad of zone: " + this.f15363a);
        }
        if (((Boolean) this.f15333b.a(b.dF)).booleanValue() && Utils.isVPNConnected() && v.a()) {
            a("User is connected to a VPN");
        }
        g T = this.f15333b.T();
        T.a(f.f15302a);
        f fVar = f.f15304c;
        if (T.b(fVar) == 0) {
            T.b(fVar, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.f15333b.u().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f15333b.a(b.f15207de)).booleanValue()) {
                JSONObject jSONObject = new JSONObject(this.f15333b.V().a(a(), false, true));
                map = new HashMap<>();
                map.put("rid", UUID.randomUUID().toString());
                if (!((Boolean) this.f15333b.a(b.ep)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15333b.z());
                }
                if (andResetCustomPostBody != null) {
                    JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                }
                andResetCustomPostBody = jSONObject;
            } else {
                Map<String, String> stringifyObjectMap = Utils.stringifyObjectMap(this.f15333b.V().a(a(), false, false));
                if (andResetCustomPostBody == null) {
                    andResetCustomPostBody = null;
                    str = "GET";
                }
                map = stringifyObjectMap;
            }
            if (Utils.isDspDemoApp(f())) {
                map.putAll(this.f15333b.u().getAndResetCustomQueryParams());
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(i());
            a(T);
            c.a<T> b2 = c.a(this.f15333b).a(b()).c(c()).a(map).b(str).b((Map<String, String>) hashMap).a(new JSONObject()).a(((Integer) this.f15333b.a(b.cS)).intValue()).a(((Boolean) this.f15333b.a(b.cT)).booleanValue()).b(((Boolean) this.f15333b.a(b.cU)).booleanValue()).b(((Integer) this.f15333b.a(b.cR)).intValue());
            if (andResetCustomPostBody != null) {
                b2.a(andResetCustomPostBody);
                b2.d(((Boolean) this.f15333b.a(b.ex)).booleanValue());
            }
            AnonymousClass1 r2 = new u<JSONObject>(b2.a(), this.f15333b) {
                public void a(int i2, String str, JSONObject jSONObject) {
                    h.this.a(i2);
                }

                public void a(JSONObject jSONObject, int i2) {
                    if (i2 == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f15438d.a());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f15438d.b());
                        h.this.b(jSONObject);
                        return;
                    }
                    h.this.a(i2);
                }
            };
            r2.a(b.aR);
            r2.b(b.aS);
            this.f15333b.S().a((a) r2);
        } catch (Throwable th) {
            if (v.a()) {
                a("Unable to fetch ad " + this.f15363a, th);
            }
            a(0);
        }
    }
}
