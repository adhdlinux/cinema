package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;

class c extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final v f14040a;

    /* renamed from: b  reason: collision with root package name */
    private final b f14041b;

    public c(b bVar, m mVar) {
        this.f14040a = mVar.A();
        this.f14041b = bVar;
    }

    public void onConsoleMessage(String str, int i2, String str2) {
        if (v.a()) {
            v vVar = this.f14040a;
            vVar.d("AdWebView", "console.log[" + i2 + "] :" + str);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (!v.a()) {
            return true;
        }
        this.f14040a.b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!v.a()) {
            return true;
        }
        v vVar = this.f14040a;
        vVar.d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!v.a()) {
            return true;
        }
        v vVar = this.f14040a;
        vVar.d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!v.a()) {
            return true;
        }
        v vVar = this.f14040a;
        vVar.d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    public void onProgressChanged(WebView webView, int i2) {
        b bVar;
        if (i2 == 100 && (bVar = this.f14041b) != null) {
            bVar.a(webView);
        }
    }
}
