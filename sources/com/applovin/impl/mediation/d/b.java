package com.applovin.impl.mediation.d;

import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.h;
import org.json.JSONObject;

public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14458a = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f14459b = {"ads", "settings", "signal_providers"};

    public static String a(m mVar) {
        return h.a((String) mVar.a(a.f15181c), "1.0/mediate", mVar);
    }

    public static void a(JSONObject jSONObject, m mVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(shallowCopy, f14458a);
            mVar.a(d.f15238x, shallowCopy.toString());
        }
    }

    public static String b(m mVar) {
        return h.a((String) mVar.a(a.f15182d), "1.0/mediate", mVar);
    }

    public static void b(JSONObject jSONObject, m mVar) {
        if (jSONObject.length() != 0) {
            if (JsonUtils.valueExists(jSONObject, "auto_init_adapters") || JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
                JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
                JsonUtils.removeObjectsForKeys(shallowCopy, f14459b);
                mVar.a(d.f15239y, shallowCopy.toString());
                return;
            }
            mVar.b(d.f15239y);
        }
    }

    public static String c(m mVar) {
        return h.a((String) mVar.a(a.f15181c), "1.0/mediate_debug", mVar);
    }

    public static String d(m mVar) {
        return h.a((String) mVar.a(a.f15182d), "1.0/mediate_debug", mVar);
    }
}
