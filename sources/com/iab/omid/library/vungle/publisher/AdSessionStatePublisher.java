package com.iab.omid.library.vungle.publisher;

import android.webkit.WebView;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.internal.g;
import com.iab.omid.library.vungle.internal.h;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.f;
import com.iab.omid.library.vungle.weakreference.b;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a  reason: collision with root package name */
    private String f31736a;

    /* renamed from: b  reason: collision with root package name */
    private b f31737b = new b((WebView) null);

    /* renamed from: c  reason: collision with root package name */
    private a f31738c;

    /* renamed from: d  reason: collision with root package name */
    private long f31739d;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f31736a = str;
    }

    public void a() {
        this.f31739d = f.b();
        this.f31738c = a.AD_STATE_IDLE;
    }

    public void b(float f2) {
        h.a().c(o(), this.f31736a, f2);
    }

    /* access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f31737b = new b(webView);
    }

    public void d(AdSessionConfiguration adSessionConfiguration) {
        h.a().e(o(), this.f31736a, adSessionConfiguration.b());
    }

    public void e(com.iab.omid.library.vungle.adsession.a aVar, AdSessionContext adSessionContext) {
        f(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void f(com.iab.omid.library.vungle.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String l2 = aVar.l();
        JSONObject jSONObject2 = new JSONObject();
        c.i(jSONObject2, "environment", "app");
        c.i(jSONObject2, "adSessionType", adSessionContext.b());
        c.i(jSONObject2, "deviceInfo", com.iab.omid.library.vungle.utils.b.d());
        c.i(jSONObject2, "deviceCategory", com.iab.omid.library.vungle.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.i(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.i(jSONObject3, "partnerName", adSessionContext.g().b());
        c.i(jSONObject3, "partnerVersion", adSessionContext.g().c());
        c.i(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.i(jSONObject4, "libraryVersion", "1.5.2-Vungle");
        c.i(jSONObject4, "appId", g.c().a().getApplicationContext().getPackageName());
        c.i(jSONObject2, "app", jSONObject4);
        if (adSessionContext.c() != null) {
            c.i(jSONObject2, "contentUrl", adSessionContext.c());
        }
        if (adSessionContext.d() != null) {
            c.i(jSONObject2, "customReferenceData", adSessionContext.d());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.h()) {
            c.i(jSONObject5, next.b(), next.c());
        }
        h.a().f(o(), l2, jSONObject2, jSONObject5, jSONObject);
    }

    public void g(String str, long j2) {
        a aVar;
        if (j2 >= this.f31739d && this.f31738c != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.f31738c = aVar;
            h.a().k(o(), this.f31736a, str);
        }
    }

    public void h(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            c.i(jSONObject, "timestamp", Long.valueOf(date.getTime()));
            h.a().i(o(), jSONObject);
        }
    }

    public void i(boolean z2) {
        if (m()) {
            h.a().l(o(), this.f31736a, z2 ? "foregrounded" : "backgrounded");
        }
    }

    public void j() {
        this.f31737b.clear();
    }

    public void k(String str, long j2) {
        if (j2 >= this.f31739d) {
            this.f31738c = a.AD_STATE_VISIBLE;
            h.a().k(o(), this.f31736a, str);
        }
    }

    public void l(boolean z2) {
        if (m()) {
            h.a().d(o(), this.f31736a, z2 ? "locked" : "unlocked");
        }
    }

    public boolean m() {
        return this.f31737b.get() != null;
    }

    public void n() {
        h.a().b(o(), this.f31736a);
    }

    public WebView o() {
        return (WebView) this.f31737b.get();
    }

    public void p() {
    }
}
