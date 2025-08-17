package com.applovin.impl.mediation.debugger.c;

import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.e.u;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.e.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b.c<JSONObject> f14559a;

    public a(b.c<JSONObject> cVar, m mVar) {
        super("TaskFetchMediationDebuggerInfo", mVar, true);
        this.f14559a = cVar;
    }

    private JSONObject a(m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", c.a(mVar));
        } catch (JSONException e2) {
            a("Failed to create mediation debugger request post body", e2);
        }
        return jSONObject;
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", c.a(this.f15333b));
        } catch (JSONException e2) {
            a("Failed to construct JSON body", e2);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ep)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15333b.z());
        }
        Map<String, Object> h2 = this.f15333b.V().h();
        hashMap.put("package_name", String.valueOf(h2.get("package_name")));
        hashMap.put("app_version", String.valueOf(h2.get("app_version")));
        Map<String, Object> b2 = this.f15333b.V().b();
        hashMap.put("platform", String.valueOf(b2.get("platform")));
        hashMap.put("os", String.valueOf(b2.get("os")));
        return hashMap;
    }

    public void run() {
        AnonymousClass1 r12 = new u<JSONObject>(com.applovin.impl.sdk.network.c.a(this.f15333b).b("POST").a(com.applovin.impl.mediation.d.b.c(this.f15333b)).c(com.applovin.impl.mediation.d.b.d(this.f15333b)).a(a()).a(a(this.f15333b)).a(new JSONObject()).b(((Long) this.f15333b.a(com.applovin.impl.sdk.c.a.f15185g)).intValue()).a(b()).a(), this.f15333b, g()) {
            public void a(int i2, String str, JSONObject jSONObject) {
                a.this.f14559a.a(i2, str, jSONObject);
            }

            public void a(JSONObject jSONObject, int i2) {
                a.this.f14559a.a(jSONObject, i2);
            }
        };
        r12.a(com.applovin.impl.sdk.c.a.f15181c);
        r12.b(com.applovin.impl.sdk.c.a.f15182d);
        this.f15333b.S().a((com.applovin.impl.sdk.e.a) r12);
    }
}
