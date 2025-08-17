package com.original.tase.helper.http.cloudflare;

import android.webkit.ValueCallback;

public final /* synthetic */ class b implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewResolver f34004a;

    public /* synthetic */ b(WebViewResolver webViewResolver) {
        this.f34004a = webViewResolver;
    }

    public final void onReceiveValue(Object obj) {
        WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1.j(this.f34004a, (String) obj);
    }
}
