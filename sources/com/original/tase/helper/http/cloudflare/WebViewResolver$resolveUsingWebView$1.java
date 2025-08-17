package com.original.tase.helper.http.cloudflare;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver", f = "WebViewResolver.kt", l = {149}, m = "resolveUsingWebView")
final class WebViewResolver$resolveUsingWebView$1 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f33938i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33939j;

    /* renamed from: k  reason: collision with root package name */
    int f33940k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$resolveUsingWebView$1(WebViewResolver webViewResolver, Continuation<? super WebViewResolver$resolveUsingWebView$1> continuation) {
        super(continuation);
        this.f33939j = webViewResolver;
    }

    public final Object invokeSuspend(Object obj) {
        this.f33938i = obj;
        this.f33940k |= Integer.MIN_VALUE;
        return this.f33939j.j((String) null, (String) null, (String) null, (Function1<? super Request, Boolean>) null, this);
    }
}
