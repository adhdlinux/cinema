package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.internal.g;
import com.iab.omid.library.vungle.internal.h;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WebView f31744e;

    /* renamed from: f  reason: collision with root package name */
    private Long f31745f = null;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f31746g;

    /* renamed from: h  reason: collision with root package name */
    private final String f31747h;

    class a extends WebViewClient {
        a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.o() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.c((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.vungle.publisher.b$b  reason: collision with other inner class name */
    class C0049b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final WebView f31749b;

        C0049b() {
            this.f31749b = b.this.f31744e;
        }

        public void run() {
            this.f31749b.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f31746g = map;
        this.f31747h = str2;
    }

    public void e(com.iab.omid.library.vungle.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> e2 = adSessionContext.e();
        for (String next : e2.keySet()) {
            c.i(jSONObject, next, e2.get(next).d());
        }
        f(aVar, adSessionContext, jSONObject);
    }

    public void j() {
        super.j();
        new Handler().postDelayed(new C0049b(), Math.max(4000 - (this.f31745f == null ? 4000 : TimeUnit.MILLISECONDS.convert(f.b() - this.f31745f.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f31744e = null;
    }

    public void p() {
        super.p();
        r();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void r() {
        WebView webView = new WebView(g.c().a());
        this.f31744e = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f31744e.getSettings().setAllowContentAccess(false);
        this.f31744e.getSettings().setAllowFileAccess(false);
        this.f31744e.setWebViewClient(new a());
        c(this.f31744e);
        h.a().m(this.f31744e, this.f31747h);
        for (String next : this.f31746g.keySet()) {
            h.a().n(this.f31744e, this.f31746g.get(next).a().toExternalForm(), next);
        }
        this.f31745f = Long.valueOf(f.b());
    }
}
