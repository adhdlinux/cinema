package com.original.tase.helper.http.cloudflare;

import android.webkit.WebView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$destroyWebView$1", f = "WebViewResolver.kt", l = {}, m = "invokeSuspend")
final class WebViewResolver$resolveUsingWebView$destroyWebView$1 extends SuspendLambda implements Function2<WebViewResolver, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33987i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<WebView> f33988j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f33989k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$resolveUsingWebView$destroyWebView$1(Ref$ObjectRef<WebView> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, Continuation<? super WebViewResolver$resolveUsingWebView$destroyWebView$1> continuation) {
        super(2, continuation);
        this.f33988j = ref$ObjectRef;
        this.f33989k = ref$BooleanRef;
    }

    /* renamed from: a */
    public final Object invoke(WebViewResolver webViewResolver, Continuation<? super Unit> continuation) {
        return ((WebViewResolver$resolveUsingWebView$destroyWebView$1) create(webViewResolver, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolver$resolveUsingWebView$destroyWebView$1(this.f33988j, this.f33989k, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f33987i == 0) {
            ResultKt.b(obj);
            WebView webView = (WebView) this.f33988j.f40429b;
            if (webView != null) {
                webView.stopLoading();
            }
            WebView webView2 = (WebView) this.f33988j.f40429b;
            if (webView2 != null) {
                webView2.destroy();
            }
            this.f33988j.f40429b = null;
            this.f33989k.f40425b = true;
            System.out.println("Destroyed webview");
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
