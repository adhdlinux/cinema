package com.startapp;

import org.json.JSONException;
import org.json.JSONObject;

public class nd {

    /* renamed from: a  reason: collision with root package name */
    public static final nd f34971a = new nd(new JSONObject());

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f34972b;

    public nd() {
        this(new JSONObject());
    }

    public final void a(int i2, Object obj) {
        try {
            this.f34972b.put(String.valueOf(i2), obj);
        } catch (JSONException unused) {
        }
    }

    public final String b(int i2) {
        Object opt = this.f34972b.opt(String.valueOf(i2));
        if (opt != null) {
            return opt.toString();
        }
        return null;
    }

    public nd(JSONObject jSONObject) {
        this.f34972b = jSONObject;
    }

    public final int a(int i2) {
        Object opt = this.f34972b.opt(String.valueOf(i2));
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        return 0;
    }
}
