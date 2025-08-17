package com.chartboost.sdk.impl;

import android.webkit.WebView;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public String f18609a;

    /* renamed from: b  reason: collision with root package name */
    public he f18610b = new he((WebView) null);

    /* renamed from: c  reason: collision with root package name */
    public k f18611c;

    /* renamed from: d  reason: collision with root package name */
    public x7 f18612d;

    /* renamed from: e  reason: collision with root package name */
    public a f18613e;

    /* renamed from: f  reason: collision with root package name */
    public long f18614f;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public t(String str) {
        a();
        this.f18609a = str;
    }

    public void a() {
        this.f18614f = ze.b();
        this.f18613e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f18610b.clear();
    }

    public k c() {
        return this.f18611c;
    }

    public x7 d() {
        return this.f18612d;
    }

    public boolean e() {
        return this.f18610b.get() != null;
    }

    public void f() {
        cf.a().a(h(), this.f18609a);
    }

    public void g() {
        cf.a().b(h(), this.f18609a);
    }

    public WebView h() {
        return (WebView) this.f18610b.get();
    }

    public void i() {
        a((JSONObject) null);
    }

    public void j() {
    }

    public void a(float f2) {
        cf.a().a(h(), this.f18609a, f2);
    }

    public void b(String str, long j2) {
        if (j2 >= this.f18614f) {
            this.f18613e = a.AD_STATE_VISIBLE;
            cf.a().a(h(), this.f18609a, str);
        }
    }

    public void a(WebView webView) {
        this.f18610b = new he(webView);
    }

    public void a(k kVar) {
        this.f18611c = kVar;
    }

    public void a(q qVar) {
        cf.a().a(h(), this.f18609a, qVar.c());
    }

    public void a(x7 x7Var) {
        this.f18612d = x7Var;
    }

    public void a(qd qdVar, r rVar) {
        a(qdVar, rVar, (JSONObject) null);
    }

    public void a(qd qdVar, r rVar, JSONObject jSONObject) {
        String j2 = qdVar.j();
        JSONObject jSONObject2 = new JSONObject();
        me.a(jSONObject2, "environment", "app");
        me.a(jSONObject2, "adSessionType", rVar.a());
        me.a(jSONObject2, "deviceInfo", ee.d());
        me.a(jSONObject2, "deviceCategory", vd.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        me.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        me.a(jSONObject3, "partnerName", rVar.f().a());
        me.a(jSONObject3, "partnerVersion", rVar.f().b());
        me.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        me.a(jSONObject4, "libraryVersion", "1.4.9-Chartboost");
        me.a(jSONObject4, "appId", bf.b().a().getApplicationContext().getPackageName());
        me.a(jSONObject2, "app", jSONObject4);
        if (rVar.b() != null) {
            me.a(jSONObject2, "contentUrl", rVar.b());
        }
        if (rVar.c() != null) {
            me.a(jSONObject2, "customReferenceData", rVar.c());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (qc qcVar : rVar.g()) {
            me.a(jSONObject5, qcVar.b(), qcVar.c());
        }
        cf.a().a(h(), j2, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j2) {
        a aVar;
        if (j2 >= this.f18614f && this.f18613e != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.f18613e = aVar;
            cf.a().a(h(), this.f18609a, str);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        cf.a().a(h(), this.f18609a, str, jSONObject);
    }

    public void a(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            me.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
            cf.a().a(h(), jSONObject);
        }
    }

    public void a(JSONObject jSONObject) {
        cf.a().b(h(), this.f18609a, jSONObject);
    }

    public void a(boolean z2) {
        if (e()) {
            cf.a().b(h(), this.f18609a, z2 ? "foregrounded" : "backgrounded");
        }
    }
}
