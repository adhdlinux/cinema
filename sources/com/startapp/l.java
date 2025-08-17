package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static l f34848a = new l();

    public void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        a(webView, "publishMediaEvent", str);
    }

    public void a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (objArr.length > 0) {
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
            sb.append(")}");
            String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new k(webView, sb2));
            }
        }
    }
}
