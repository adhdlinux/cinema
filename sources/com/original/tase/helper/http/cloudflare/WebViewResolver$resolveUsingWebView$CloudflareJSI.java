package com.original.tase.helper.http.cloudflare;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Request;

public final class WebViewResolver$resolveUsingWebView$CloudflareJSI {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<Request, Boolean> f33982a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Request f33983b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33984c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<WebView> f33985d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f33986e;

    public WebViewResolver$resolveUsingWebView$CloudflareJSI(Function1<? super Request, Boolean> function1, Request request, WebViewResolver webViewResolver, Ref$ObjectRef<WebView> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef) {
        Intrinsics.f(function1, "$requestCallBack");
        Intrinsics.f(request, "$mainRequest");
        Intrinsics.f(webViewResolver, "this$0");
        Intrinsics.f(ref$ObjectRef, "$webView");
        Intrinsics.f(ref$BooleanRef, "$shouldExit");
        this.f33982a = function1;
        this.f33983b = request;
        this.f33984c = webViewResolver;
        this.f33985d = ref$ObjectRef;
        this.f33986e = ref$BooleanRef;
    }

    @JavascriptInterface
    public final void leave() {
        this.f33982a.invoke(this.f33983b);
        WebViewResolver.n(this.f33984c, this.f33985d, this.f33986e);
    }
}
