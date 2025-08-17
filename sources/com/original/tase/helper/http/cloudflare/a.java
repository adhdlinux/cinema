package com.original.tase.helper.http.cloudflare;

import android.webkit.WebView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f34002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebViewResolver f34003c;

    public /* synthetic */ a(WebView webView, WebViewResolver webViewResolver) {
        this.f34002b = webView;
        this.f34003c = webViewResolver;
    }

    public final void run() {
        WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1.i(this.f34002b, this.f34003c);
    }
}
