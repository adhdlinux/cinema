package com.facebook.ads.internal.n;

import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f20376a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20377b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20378c;

    public h(String str, int i2, int i3) {
        this.f20376a = str;
        this.f20377b = i2;
        this.f20378c = i3;
    }

    public static h a(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString(ImagesContract.URL)) == null) {
            return null;
        }
        return new h(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    public String a() {
        return this.f20376a;
    }

    public int b() {
        return this.f20377b;
    }

    public int c() {
        return this.f20378c;
    }
}
