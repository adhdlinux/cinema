package com.iab.omid.library.adcolony.publisher;

import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.media.MediaEvents;
import com.iab.omid.library.adcolony.b.d;
import com.iab.omid.library.adcolony.b.e;
import com.iab.omid.library.adcolony.e.b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a  reason: collision with root package name */
    private b f31408a = new b((WebView) null);

    /* renamed from: b  reason: collision with root package name */
    private AdEvents f31409b;

    /* renamed from: c  reason: collision with root package name */
    private MediaEvents f31410c;

    /* renamed from: d  reason: collision with root package name */
    private a f31411d;

    /* renamed from: e  reason: collision with root package name */
    private long f31412e;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        x();
    }

    public void a() {
    }

    public void b(float f2) {
        e.a().c(v(), f2);
    }

    /* access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f31408a = new b(webView);
    }

    public void d(AdEvents adEvents) {
        this.f31409b = adEvents;
    }

    public void e(AdSessionConfiguration adSessionConfiguration) {
        e.a().j(v(), adSessionConfiguration.d());
    }

    public void f(ErrorType errorType, String str) {
        e.a().d(v(), errorType, str);
    }

    public void g(com.iab.omid.library.adcolony.adsession.a aVar, AdSessionContext adSessionContext) {
        h(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void h(com.iab.omid.library.adcolony.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String e2 = aVar.e();
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "environment", "app");
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "adSessionType", adSessionContext.c());
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "deviceInfo", com.iab.omid.library.adcolony.d.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.adcolony.d.b.h(jSONObject3, "partnerName", adSessionContext.h().b());
        com.iab.omid.library.adcolony.d.b.h(jSONObject3, "partnerVersion", adSessionContext.h().c());
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.adcolony.d.b.h(jSONObject4, "libraryVersion", "1.3.30-Adcolony");
        com.iab.omid.library.adcolony.d.b.h(jSONObject4, "appId", d.a().c().getApplicationContext().getPackageName());
        com.iab.omid.library.adcolony.d.b.h(jSONObject2, "app", jSONObject4);
        if (adSessionContext.d() != null) {
            com.iab.omid.library.adcolony.d.b.h(jSONObject2, "contentUrl", adSessionContext.d());
        }
        if (adSessionContext.e() != null) {
            com.iab.omid.library.adcolony.d.b.h(jSONObject2, "customReferenceData", adSessionContext.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.i()) {
            com.iab.omid.library.adcolony.d.b.h(jSONObject5, next.d(), next.e());
        }
        e.a().g(v(), e2, jSONObject2, jSONObject5, jSONObject);
    }

    public void i(MediaEvents mediaEvents) {
        this.f31410c = mediaEvents;
    }

    public void j(String str) {
        e.a().f(v(), str, (JSONObject) null);
    }

    public void k(String str, long j2) {
        if (j2 >= this.f31412e) {
            this.f31411d = a.AD_STATE_VISIBLE;
            e.a().n(v(), str);
        }
    }

    public void l(String str, JSONObject jSONObject) {
        e.a().f(v(), str, jSONObject);
    }

    public void m(JSONObject jSONObject) {
        e.a().o(v(), jSONObject);
    }

    public void n(boolean z2) {
        if (s()) {
            e.a().q(v(), z2 ? "foregrounded" : "backgrounded");
        }
    }

    public void o() {
        this.f31408a.clear();
    }

    public void p(String str, long j2) {
        a aVar;
        if (j2 >= this.f31412e && this.f31411d != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.f31411d = aVar;
            e.a().n(v(), str);
        }
    }

    public AdEvents q() {
        return this.f31409b;
    }

    public MediaEvents r() {
        return this.f31410c;
    }

    public boolean s() {
        return this.f31408a.get() != null;
    }

    public void t() {
        e.a().b(v());
    }

    public void u() {
        e.a().m(v());
    }

    public WebView v() {
        return (WebView) this.f31408a.get();
    }

    public void w() {
        e.a().p(v());
    }

    public void x() {
        this.f31412e = com.iab.omid.library.adcolony.d.d.a();
        this.f31411d = a.AD_STATE_IDLE;
    }
}
