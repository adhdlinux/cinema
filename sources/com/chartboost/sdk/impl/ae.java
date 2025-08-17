package com.chartboost.sdk.impl;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class ae extends t {

    /* renamed from: g  reason: collision with root package name */
    public WebView f17246g;

    /* renamed from: h  reason: collision with root package name */
    public Long f17247h = null;

    /* renamed from: i  reason: collision with root package name */
    public final Map f17248i;

    /* renamed from: j  reason: collision with root package name */
    public final String f17249j;

    public class a extends WebViewClient {
        public a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (ae.this.h() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                ae.this.a((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final WebView f17251b;

        public b() {
            this.f17251b = ae.this.f17246g;
        }

        public void run() {
            this.f17251b.destroy();
        }
    }

    public ae(String str, Map map, String str2) {
        super(str);
        this.f17248i = map;
        this.f17249j = str2;
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new b(), Math.max(4000 - (this.f17247h == null ? 4000 : TimeUnit.MILLISECONDS.convert(ze.b() - this.f17247h.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f17246g = null;
    }

    public void j() {
        super.j();
        k();
    }

    public void k() {
        WebView webView = new WebView(bf.b().a());
        this.f17246g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f17246g.getSettings().setAllowContentAccess(false);
        this.f17246g.getSettings().setAllowFileAccess(false);
        this.f17246g.setWebViewClient(new a());
        a(this.f17246g);
        cf.a().c(this.f17246g, this.f17249j);
        for (String str : this.f17248i.keySet()) {
            cf.a().c(this.f17246g, ((qc) this.f17248i.get(str)).a().toExternalForm(), str);
        }
        this.f17247h = Long.valueOf(ze.b());
    }

    public void a(qd qdVar, r rVar) {
        JSONObject jSONObject = new JSONObject();
        Map d2 = rVar.d();
        for (String str : d2.keySet()) {
            me.a(jSONObject, str, ((qc) d2.get(str)).d());
        }
        a(qdVar, rVar, jSONObject);
    }
}
