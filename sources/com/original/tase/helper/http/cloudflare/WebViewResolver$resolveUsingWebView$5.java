package com.original.tase.helper.http.cloudflare;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.original.Constants;
import com.original.tase.Logger;
import com.utils.Utils;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Headers;
import okhttp3.Request;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$5", f = "WebViewResolver.kt", l = {}, m = "invokeSuspend")
final class WebViewResolver$resolveUsingWebView$5 extends SuspendLambda implements Function2<WebViewResolver, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33954i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<WebView> f33955j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ String f33956k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Headers f33957l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33958m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ Function1<Request, Boolean> f33959n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ Request f33960o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f33961p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<Request> f33962q;

    /* renamed from: r  reason: collision with root package name */
    final /* synthetic */ List<Request> f33963r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$resolveUsingWebView$5(Ref$ObjectRef<WebView> ref$ObjectRef, String str, Headers headers, WebViewResolver webViewResolver, Function1<? super Request, Boolean> function1, Request request, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<Request> ref$ObjectRef2, List<Request> list, Continuation<? super WebViewResolver$resolveUsingWebView$5> continuation) {
        super(2, continuation);
        this.f33955j = ref$ObjectRef;
        this.f33956k = str;
        this.f33957l = headers;
        this.f33958m = webViewResolver;
        this.f33959n = function1;
        this.f33960o = request;
        this.f33961p = ref$BooleanRef;
        this.f33962q = ref$ObjectRef2;
        this.f33963r = list;
    }

    /* renamed from: a */
    public final Object invoke(WebViewResolver webViewResolver, Continuation<? super Unit> continuation) {
        return ((WebViewResolver$resolveUsingWebView$5) create(webViewResolver, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolver$resolveUsingWebView$5(this.f33955j, this.f33956k, this.f33957l, this.f33958m, this.f33959n, this.f33960o, this.f33961p, this.f33962q, this.f33963r, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f33954i == 0) {
            ResultKt.b(obj);
            WebView.setWebContentsDebuggingEnabled(true);
            try {
                Ref$ObjectRef<WebView> ref$ObjectRef = this.f33955j;
                Context v2 = Utils.v();
                if (v2 != null) {
                    T webView = new WebView(v2);
                    WebViewResolver webViewResolver = this.f33958m;
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setDomStorageEnabled(true);
                    WebViewResolver.f33920h.c(webView.getSettings().getUserAgentString());
                    if (webViewResolver.i() != null) {
                        webView.getSettings().setUserAgentString(webViewResolver.i());
                    }
                    ref$ObjectRef.f40429b = webView;
                    Ref$ObjectRef<WebView> ref$ObjectRef2 = this.f33955j;
                    WebView webView2 = (WebView) ref$ObjectRef2.f40429b;
                    if (webView2 != null) {
                        webView2.addJavascriptInterface(new WebViewResolver$resolveUsingWebView$CloudflareJSI(this.f33959n, this.f33960o, this.f33958m, ref$ObjectRef2, this.f33961p), "CloudflareJSI");
                    }
                    WebView webView3 = (WebView) this.f33955j.f40429b;
                    if (webView3 != null) {
                        final Request request = this.f33960o;
                        final Ref$ObjectRef<Request> ref$ObjectRef3 = this.f33962q;
                        final WebViewResolver webViewResolver2 = this.f33958m;
                        final List<Request> list = this.f33963r;
                        final Function1<Request, Boolean> function1 = this.f33959n;
                        final Ref$ObjectRef<WebView> ref$ObjectRef4 = this.f33955j;
                        final Ref$BooleanRef ref$BooleanRef = this.f33961p;
                        webView3.setWebViewClient(new WebViewClient() {
                            public void onPageFinished(WebView webView, String str) {
                                super.onPageFinished(webView, str);
                                if (webView != null) {
                                    webView.evaluateJavascript(Constants.a(), (ValueCallback) null);
                                }
                            }

                            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                                if (sslErrorHandler != null) {
                                    sslErrorHandler.proceed();
                                }
                            }

                            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                                Intrinsics.f(webView, "view");
                                Intrinsics.f(webResourceRequest, AdActivity.REQUEST_KEY_EXTRA);
                                return (WebResourceResponse) BuildersKt__BuildersKt.b((CoroutineContext) null, new WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1(webResourceRequest, request, ref$ObjectRef3, webViewResolver2, list, this, webView, function1, ref$ObjectRef4, ref$BooleanRef, (Continuation<? super WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1>) null), 1, (Object) null);
                            }
                        });
                    }
                    WebView webView4 = (WebView) this.f33955j.f40429b;
                    if (webView4 != null) {
                        webView4.loadUrl(this.f33956k, MapsKt__MapsKt.s(this.f33957l));
                    }
                    return Unit.f40298a;
                }
                throw new RuntimeException("No base context in WebViewResolver");
            } catch (Exception e2) {
                Logger.d(e2, new boolean[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
