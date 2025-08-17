package com.iab.omid.library.applovin.publisher;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.b.d;
import com.iab.omid.library.applovin.b.e;
import com.iab.omid.library.applovin.e.b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a  reason: collision with root package name */
    private b f31525a = new b((WebView) null);

    /* renamed from: b  reason: collision with root package name */
    private AdEvents f31526b;

    /* renamed from: c  reason: collision with root package name */
    private MediaEvents f31527c;

    /* renamed from: d  reason: collision with root package name */
    private a f31528d;

    /* renamed from: e  reason: collision with root package name */
    private long f31529e;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        i();
    }

    public void a() {
    }

    public void a(float f2) {
        e.a().a(getWebView(), f2);
    }

    /* access modifiers changed from: package-private */
    public void a(WebView webView) {
        this.f31525a = new b(webView);
    }

    public void a(AdEvents adEvents) {
        this.f31526b = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        e.a().a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        e.a().a(getWebView(), errorType, str);
    }

    public void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "environment", "app");
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "deviceInfo", com.iab.omid.library.applovin.d.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.applovin.d.b.a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        com.iab.omid.library.applovin.d.b.a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.applovin.d.b.a(jSONObject4, "libraryVersion", "1.3.30-Applovin");
        com.iab.omid.library.applovin.d.b.a(jSONObject4, "appId", d.a().b().getApplicationContext().getPackageName());
        com.iab.omid.library.applovin.d.b.a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            com.iab.omid.library.applovin.d.b.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            com.iab.omid.library.applovin.d.b.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            com.iab.omid.library.applovin.d.b.a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        e.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f31527c = mediaEvents;
    }

    public void a(String str) {
        e.a().a(getWebView(), str, (JSONObject) null);
    }

    public void a(String str, long j2) {
        if (j2 >= this.f31529e) {
            this.f31528d = a.AD_STATE_VISIBLE;
            e.a().b(getWebView(), str);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        e.a().a(getWebView(), str, jSONObject);
    }

    public void a(JSONObject jSONObject) {
        e.a().b(getWebView(), jSONObject);
    }

    public void a(boolean z2) {
        if (e()) {
            e.a().c(getWebView(), z2 ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.f31525a.clear();
    }

    public void b(String str, long j2) {
        a aVar;
        if (j2 >= this.f31529e && this.f31528d != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.f31528d = aVar;
            e.a().b(getWebView(), str);
        }
    }

    public AdEvents c() {
        return this.f31526b;
    }

    public MediaEvents d() {
        return this.f31527c;
    }

    public boolean e() {
        return this.f31525a.get() != null;
    }

    public void f() {
        e.a().a(getWebView());
    }

    public void g() {
        e.a().b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f31525a.get();
    }

    public void h() {
        e.a().c(getWebView());
    }

    public void i() {
        this.f31529e = com.iab.omid.library.applovin.d.d.a();
        this.f31528d = a.AD_STATE_IDLE;
    }
}
