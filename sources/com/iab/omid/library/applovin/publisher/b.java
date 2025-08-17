package com.iab.omid.library.applovin.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.a;
import com.iab.omid.library.applovin.b.e;
import com.iab.omid.library.applovin.d.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WebView f31534a;

    /* renamed from: b  reason: collision with root package name */
    private Long f31535b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f31536c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31537d;

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.f31536c = map;
        this.f31537d = str;
    }

    public void a() {
        super.a();
        j();
    }

    public void a(a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            com.iab.omid.library.applovin.d.b.a(jSONObject, next, injectedResourcesMap.get(next));
        }
        a(aVar, adSessionContext, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            private final WebView f31539b;

            {
                this.f31539b = b.this.f31534a;
            }

            public void run() {
                this.f31539b.destroy();
            }
        }, Math.max(4000 - (this.f31535b == null ? 4000 : TimeUnit.MILLISECONDS.convert(d.a() - this.f31535b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f31534a = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void j() {
        WebView webView = new WebView(com.iab.omid.library.applovin.b.d.a().b());
        this.f31534a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f31534a);
        e.a().a(this.f31534a, this.f31537d);
        for (String next : this.f31536c.keySet()) {
            e.a().a(this.f31534a, this.f31536c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f31535b = Long.valueOf(d.a());
    }
}
