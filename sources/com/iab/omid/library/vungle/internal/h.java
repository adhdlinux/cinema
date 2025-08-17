package com.iab.omid.library.vungle.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.iab.omid.library.vungle.utils.d;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f31717a = new h();

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebView f31718b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f31719c;

        a(WebView webView, String str) {
            this.f31718b = webView;
            this.f31719c = str;
        }

        public void run() {
            h.this.m(this.f31718b, this.f31719c);
        }
    }

    private h() {
    }

    public static final h a() {
        return f31717a;
    }

    public void b(WebView webView, String str) {
        g(webView, "finishSession", str);
    }

    public void c(WebView webView, String str, float f2) {
        g(webView, "setDeviceVolume", Float.valueOf(f2), str);
    }

    public void d(WebView webView, String str, String str2) {
        g(webView, "setDeviceLockState", str2);
    }

    public void e(WebView webView, String str, JSONObject jSONObject) {
        g(webView, "init", jSONObject, str);
    }

    public void f(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        g(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    public void g(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            j(sb, objArr);
            sb.append(")}");
            h(webView, sb);
            return;
        }
        d.a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    public void h(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            m(webView, sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    public void i(WebView webView, JSONObject jSONObject) {
        g(webView, "setLastActivity", jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void j(StringBuilder sb, Object[] objArr) {
        String obj;
        if (objArr != null && objArr.length > 0) {
            for (Object obj2 : objArr) {
                if (obj2 == null) {
                    obj = "null";
                } else {
                    if (obj2 instanceof String) {
                        obj = obj2.toString();
                        if (!obj.startsWith("{")) {
                            sb.append('\"');
                            sb.append(obj);
                            sb.append('\"');
                        }
                    } else {
                        sb.append(obj2);
                    }
                    sb.append(",");
                }
                sb.append(obj);
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public void k(WebView webView, String str, String str2) {
        g(webView, "setNativeViewHierarchy", str2, str);
    }

    public void l(WebView webView, String str, String str2) {
        g(webView, "setState", str2, str);
    }

    public boolean m(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: " + str);
            return true;
        }
    }

    public void n(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            m(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }
}
