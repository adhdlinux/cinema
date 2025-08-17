package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class b extends a {
    b(m mVar) {
        super("TaskApiSubmitData", mVar);
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            JSONObject a2 = h.a(jSONObject);
            this.f15333b.K().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.X, (Object) a2.getString("device_id"));
            this.f15333b.K().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.Z, (Object) a2.getString("device_token"));
            this.f15333b.K().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.aa, (Object) Long.valueOf(a2.getLong("publisher_id")));
            h.d(a2, this.f15333b);
            h.e(a2, this.f15333b);
            String string = JsonUtils.getString(a2, "latest_version", "");
            if (!TextUtils.isEmpty(string)) {
                String str = AppLovinSdk.VERSION;
                if (!str.equals(string) && v.a()) {
                    String str2 = "Current SDK version (" + str + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                    if (JsonUtils.valueExists(a2, "sdk_update_message")) {
                        str2 = JsonUtils.getString(a2, "sdk_update_message", str2);
                    }
                    v.h("AppLovinSdk", str2);
                }
            }
            this.f15333b.T().b();
        } catch (Throwable th) {
            if (v.a()) {
                a("Unable to parse API response", th);
            }
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        o V = this.f15333b.V();
        Map<String, Object> d2 = V.d();
        Utils.renameKeyInObjectMap("platform", "type", d2);
        Utils.renameKeyInObjectMap("api_level", "sdk_version", d2);
        jSONObject.put("device_info", new JSONObject(d2));
        Map<String, Object> h2 = V.h();
        Utils.renameKeyInObjectMap("sdk_version", "applovin_sdk_version", h2);
        Utils.renameKeyInObjectMap("ia", "installed_at", h2);
        jSONObject.put("app_info", new JSONObject(h2));
    }

    private void c(JSONObject jSONObject) {
        AnonymousClass1 r02 = new u<JSONObject>(c.a(this.f15333b).a(h.a("2.0/device", this.f15333b)).c(h.b("2.0/device", this.f15333b)).a(h.e(this.f15333b)).b("POST").a(jSONObject).d(((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ew)).booleanValue()).a(new JSONObject()).a(((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.cV)).intValue()).a(), this.f15333b) {
            public void a(int i2, String str, JSONObject jSONObject) {
                h.a(i2, this.f15333b);
            }

            public void a(JSONObject jSONObject, int i2) {
                b.this.a(jSONObject);
            }
        };
        r02.a(com.applovin.impl.sdk.c.b.aT);
        r02.b(com.applovin.impl.sdk.c.b.aU);
        this.f15333b.S().a((a) r02);
    }

    public void run() {
        try {
            if (v.a()) {
                b("Submitting user data...");
            }
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            c(jSONObject);
        } catch (JSONException e2) {
            if (v.a()) {
                a("Unable to build JSON message with collected data", e2);
            }
        }
    }
}
