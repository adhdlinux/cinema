package com.facebook.ads.internal.adapters.a;

import android.content.Context;
import com.facebook.ads.internal.adapters.a.i;
import com.facebook.ads.internal.q.d.a;
import com.facebook.ads.internal.q.d.b;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements Serializable {
    private static final long serialVersionUID = 8751287062553772011L;

    /* renamed from: a  reason: collision with root package name */
    private final i f19719a;

    /* renamed from: b  reason: collision with root package name */
    private final a f19720b;

    /* renamed from: c  reason: collision with root package name */
    private final List<h> f19721c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19722d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19723e;

    /* renamed from: f  reason: collision with root package name */
    private int f19724f = 200;

    /* renamed from: g  reason: collision with root package name */
    private final String f19725g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19726h;

    private g(i iVar, a aVar, List<h> list, String str, String str2, int i2, int i3) {
        this.f19719a = iVar;
        this.f19720b = aVar;
        this.f19721c = list;
        this.f19725g = str;
        this.f19726h = str2;
        this.f19722d = i2;
        this.f19723e = i3;
    }

    public static g a(JSONObject jSONObject, Context context) {
        i a2 = new i.a().a(jSONObject.optString("title")).b(jSONObject.optJSONObject("icon") != null ? jSONObject.optJSONObject("icon").optString(ImagesContract.URL) : "").c(jSONObject.optString("ad_choices_link_url")).d(a(jSONObject)).a();
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        JSONObject jSONObject2 = null;
        d a3 = d.a(optJSONObject != null ? optJSONObject.optJSONObject("portrait") : null);
        if (optJSONObject != null) {
            jSONObject2 = optJSONObject.optJSONObject("landscape");
        }
        a aVar = new a(a3, d.a(jSONObject2));
        int optInt = jSONObject.optInt("viewability_check_initial_delay", 0);
        int optInt2 = jSONObject.optInt("viewability_check_interval", 1000);
        String optString = jSONObject.optString("ct");
        String optString2 = jSONObject.optString("request_id", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            arrayList.add(h.a(jSONObject));
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    arrayList.add(h.a(optJSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    a.a(context, "parsing", b.f20761u, (Exception) e2);
                    e2.printStackTrace();
                }
            }
        }
        return new g(a2, aVar, arrayList, optString, optString2, optInt, optInt2);
    }

    private static String a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("generic_text");
        return optJSONObject == null ? "Sponsored" : optJSONObject.optString("sponsored", "Sponsored");
    }

    public i a() {
        return this.f19719a;
    }

    public void a(int i2) {
        this.f19724f = i2;
    }

    public a b() {
        return this.f19720b;
    }

    public String c() {
        return this.f19725g;
    }

    public List<h> d() {
        return Collections.unmodifiableList(this.f19721c);
    }

    public String e() {
        return this.f19726h;
    }

    public int f() {
        return this.f19722d;
    }

    public int g() {
        return this.f19723e;
    }

    public int h() {
        return this.f19724f;
    }
}
