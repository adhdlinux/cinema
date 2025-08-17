package com.facebook.ads.internal.o;

import android.text.TextUtils;
import com.facebook.ads.internal.h.a;
import com.facebook.ads.internal.h.c;
import com.facebook.ads.internal.h.d;
import com.facebook.ads.internal.o.f;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f20434a = new e();

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            eVar = f20434a;
        }
        return eVar;
    }

    private g a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        c cVar = new c(d.a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                cVar.a(new a(jSONObject3.optString("adapter"), jSONObject3.optJSONObject("data"), jSONObject3.optJSONArray("trackers")));
            }
        }
        return new g(cVar, jSONObject.optString("server_request_id"), jSONObject.optString("server_response"), jSONObject.optString("an_validation_uuid"));
    }

    private h b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
            return new h(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), new c(d.a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config")));
        } catch (JSONException unused) {
            return c(jSONObject);
        }
    }

    private h c(JSONObject jSONObject) {
        return new h(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), (c) null);
    }

    public f a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            optString.hashCode();
            if (optString.equals("ads")) {
                return a(jSONObject);
            }
            if (optString.equals(MRAIDPresenter.ERROR)) {
                return b(jSONObject);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(MRAIDPresenter.ERROR);
            if (optJSONObject != null) {
                return c(optJSONObject);
            }
        }
        return new f(f.a.UNKNOWN);
    }
}
