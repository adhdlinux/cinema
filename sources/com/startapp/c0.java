package com.startapp;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class c0 extends AdSessionStatePublisher {

    /* renamed from: f  reason: collision with root package name */
    public WebView f34277f;

    /* renamed from: g  reason: collision with root package name */
    public Long f34278g = null;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, w> f34279h;

    /* renamed from: i  reason: collision with root package name */
    public final String f34280i;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WebView f34281a;

        public a(c0 c0Var) {
            this.f34281a = c0Var.f34277f;
        }

        public void run() {
            this.f34281a.destroy();
        }
    }

    public c0(Map<String, w> map, String str) {
        this.f34279h = map;
        this.f34280i = str;
    }

    public void a(x xVar, u uVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, w> unmodifiableMap = Collections.unmodifiableMap(uVar.f36595d);
        for (String next : unmodifiableMap.keySet()) {
            fg.a(jSONObject, next, unmodifiableMap.get(next));
        }
        a(xVar, uVar, jSONObject);
    }

    public void b() {
        long j2;
        this.f31609a.clear();
        if (this.f34278g == null) {
            j2 = 4000;
        } else {
            j2 = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f34278g.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new a(this), Math.max(4000 - j2, 2000));
        this.f34277f = null;
    }

    public void d() {
        WebView webView = new WebView(j.f34712a.f34713b);
        this.f34277f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f31609a = new og(this.f34277f);
        WebView webView2 = this.f34277f;
        String str = this.f34280i;
        if (webView2 != null && !TextUtils.isEmpty(str)) {
            webView2.loadUrl("javascript: " + str);
        }
        for (String next : this.f34279h.keySet()) {
            String externalForm = this.f34279h.get(next).f36755b.toExternalForm();
            WebView webView3 = this.f34277f;
            if (externalForm != null && !TextUtils.isEmpty(next)) {
                String replace = "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", next);
                if (webView3 != null && !TextUtils.isEmpty(replace)) {
                    webView3.loadUrl("javascript: " + replace);
                }
            }
        }
        this.f34278g = Long.valueOf(System.nanoTime());
    }
}
