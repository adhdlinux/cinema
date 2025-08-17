package com.facebook.ads.internal.adapters.a;

import android.graphics.Color;
import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final int f19700a = Color.parseColor("#90949c");

    /* renamed from: b  reason: collision with root package name */
    public static final int f19701b = Color.parseColor("#4b4f56");

    /* renamed from: c  reason: collision with root package name */
    public static final int f19702c = Color.parseColor("#f6f7f9");

    /* renamed from: d  reason: collision with root package name */
    public static final int f19703d = Color.parseColor("#ff4080ff");

    /* renamed from: e  reason: collision with root package name */
    public static final int f19704e = Color.parseColor("#23272F");

    /* renamed from: f  reason: collision with root package name */
    public static final int f19705f = Color.parseColor("#ff4080ff");
    private static final long serialVersionUID = 8946536326456653736L;

    /* renamed from: g  reason: collision with root package name */
    private int f19706g = f19700a;

    /* renamed from: h  reason: collision with root package name */
    private int f19707h = f19701b;

    /* renamed from: i  reason: collision with root package name */
    private int f19708i = -16777216;

    /* renamed from: j  reason: collision with root package name */
    private int f19709j = f19702c;

    /* renamed from: k  reason: collision with root package name */
    private int f19710k = f19703d;

    /* renamed from: l  reason: collision with root package name */
    private int f19711l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f19712m = -16777216;

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        if (jSONObject != null) {
            String optString = jSONObject.optString("accent_color");
            String optString2 = jSONObject.optString("body_color");
            String optString3 = jSONObject.optString("subtitle_color");
            String optString4 = jSONObject.optString("bg_color");
            String optString5 = jSONObject.optString("cta_color");
            String optString6 = jSONObject.optString("cta_text_color");
            String optString7 = jSONObject.optString("title_color");
            if (!TextUtils.isEmpty(optString)) {
                dVar.f19706g = Color.parseColor(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                dVar.f19707h = Color.parseColor(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                dVar.f19708i = Color.parseColor(optString3);
            }
            if (!TextUtils.isEmpty(optString4)) {
                dVar.f19709j = Color.parseColor(optString4);
            }
            if (!TextUtils.isEmpty(optString5)) {
                dVar.f19710k = Color.parseColor(optString5);
            }
            if (!TextUtils.isEmpty(optString6)) {
                dVar.f19711l = Color.parseColor(optString6);
            }
            if (!TextUtils.isEmpty(optString7)) {
                dVar.f19712m = Color.parseColor(optString7);
            }
        }
        return dVar;
    }

    public int a(boolean z2) {
        if (z2) {
            return -1;
        }
        return this.f19706g;
    }

    public int b(boolean z2) {
        if (z2) {
            return -1;
        }
        return this.f19707h;
    }

    public int c(boolean z2) {
        if (z2) {
            return -1;
        }
        return this.f19708i;
    }

    public int d(boolean z2) {
        return z2 ? f19704e : this.f19709j;
    }

    public int e(boolean z2) {
        if (z2) {
            return -1;
        }
        return this.f19710k;
    }

    public int f(boolean z2) {
        return z2 ? f19705f : this.f19711l;
    }

    public int g(boolean z2) {
        if (z2) {
            return -1;
        }
        return this.f19712m;
    }
}
