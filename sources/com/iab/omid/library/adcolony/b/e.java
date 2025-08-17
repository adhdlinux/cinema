package com.iab.omid.library.adcolony.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.d.c;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f31382a = new e();

    private e() {
    }

    public static final e a() {
        return f31382a;
    }

    public void b(WebView webView) {
        h(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f2) {
        h(webView, "setDeviceVolume", Float.valueOf(f2));
    }

    public void d(WebView webView, ErrorType errorType, String str) {
        h(webView, MRAIDPresenter.ERROR, errorType.toString(), str);
    }

    public void e(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            l(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    public void f(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            h(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        h(webView, "publishMediaEvent", str);
    }

    public void g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    public void h(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            k(sb, objArr);
            sb.append(")}");
            i(webView, sb);
            return;
        }
        c.a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    public void i(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    public void j(WebView webView, JSONObject jSONObject) {
        h(webView, "init", jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void k(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.append('\"');
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public boolean l(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    public void m(WebView webView) {
        h(webView, "publishImpressionEvent", new Object[0]);
    }

    public void n(WebView webView, String str) {
        h(webView, "setNativeViewHierarchy", str);
    }

    public void o(WebView webView, JSONObject jSONObject) {
        h(webView, "publishLoadedEvent", jSONObject);
    }

    public void p(WebView webView) {
        h(webView, "publishLoadedEvent", new Object[0]);
    }

    public void q(WebView webView, String str) {
        h(webView, "setState", str);
    }
}
