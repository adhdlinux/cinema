package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

public class cf {

    /* renamed from: a  reason: collision with root package name */
    public static cf f17392a = new cf();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebView f17393b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17394c;

        public a(WebView webView, String str) {
            this.f17393b = webView;
            this.f17394c = str;
        }

        public void run() {
            cf.this.c(this.f17393b, this.f17394c);
        }
    }

    public static final cf a() {
        return f17392a;
    }

    public void b(WebView webView, String str) {
        a(webView, "publishImpressionEvent", str);
    }

    public void c(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            c(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    public void a(WebView webView, String str) {
        a(webView, "finishSession", str);
    }

    public void b(WebView webView, String str, String str2) {
        a(webView, "setState", str2, str);
    }

    public boolean c(WebView webView, String str) {
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

    public void a(WebView webView, String str, float f2) {
        a(webView, "setDeviceVolume", Float.valueOf(f2), str);
    }

    public void b(WebView webView, String str, JSONObject jSONObject) {
        a(webView, "publishLoadedEvent", jSONObject, str);
    }

    public void a(WebView webView, String str, String str2) {
        a(webView, "setNativeViewHierarchy", str2, str);
    }

    public void a(WebView webView, String str, String str2, JSONObject jSONObject) {
        a(webView, "publishMediaEvent", str2, jSONObject, str);
    }

    public void a(WebView webView, String str, JSONObject jSONObject) {
        a(webView, "init", jSONObject, str);
    }

    public void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public void a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            a(sb, objArr);
            sb.append(")}");
            a(webView, sb);
            return;
        }
        se.a("The WebView is null for " + str);
    }

    public void a(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            c(webView, sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        a(webView, "setLastActivity", jSONObject);
    }

    public void a(StringBuilder sb, Object[] objArr) {
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
}
