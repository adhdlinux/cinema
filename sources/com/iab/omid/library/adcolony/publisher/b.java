package com.iab.omid.library.adcolony.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.a;
import com.iab.omid.library.adcolony.b.e;
import com.iab.omid.library.adcolony.d.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WebView f31417f;

    /* renamed from: g  reason: collision with root package name */
    private Long f31418g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f31419h;

    /* renamed from: i  reason: collision with root package name */
    private final String f31420i;

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.f31419h = map;
        this.f31420i = str;
    }

    public void a() {
        super.a();
        z();
    }

    public void g(a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> f2 = adSessionContext.f();
        for (String next : f2.keySet()) {
            com.iab.omid.library.adcolony.d.b.h(jSONObject, next, f2.get(next));
        }
        h(aVar, adSessionContext, jSONObject);
    }

    public void o() {
        super.o();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            private final WebView f31421b;

            {
                this.f31421b = b.this.f31417f;
            }

            public void run() {
                this.f31421b.destroy();
            }
        }, Math.max(4000 - (this.f31418g == null ? 4000 : TimeUnit.MILLISECONDS.convert(d.a() - this.f31418g.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f31417f = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void z() {
        WebView webView = new WebView(com.iab.omid.library.adcolony.b.d.a().c());
        this.f31417f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        c(this.f31417f);
        e.a().l(this.f31417f, this.f31420i);
        for (String next : this.f31419h.keySet()) {
            e.a().e(this.f31417f, this.f31419h.get(next).c().toExternalForm(), next);
        }
        this.f31418g = Long.valueOf(d.a());
    }
}
