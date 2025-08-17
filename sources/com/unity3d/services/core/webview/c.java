package com.unity3d.services.core.webview;

import android.webkit.ValueCallback;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f37220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37221c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ValueCallback f37222d;

    public /* synthetic */ c(WebView webView, String str, ValueCallback valueCallback) {
        this.f37220b = webView;
        this.f37221c = str;
        this.f37222d = valueCallback;
    }

    public final void run() {
        WebView.evaluateJavascript$lambda$1(this.f37220b, this.f37221c, this.f37222d);
    }
}
