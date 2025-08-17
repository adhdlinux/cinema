package com.original.tase.helper.http.cloudflare;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver", f = "WebViewResolver.kt", l = {369}, m = "resolveUsingWebView")
final class WebViewResolver$resolveUsingWebView$3 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    Object f33942i;

    /* renamed from: j  reason: collision with root package name */
    Object f33943j;

    /* renamed from: k  reason: collision with root package name */
    Object f33944k;

    /* renamed from: l  reason: collision with root package name */
    Object f33945l;

    /* renamed from: m  reason: collision with root package name */
    Object f33946m;

    /* renamed from: n  reason: collision with root package name */
    int f33947n;

    /* renamed from: o  reason: collision with root package name */
    long f33948o;

    /* renamed from: p  reason: collision with root package name */
    long f33949p;

    /* renamed from: q  reason: collision with root package name */
    /* synthetic */ Object f33950q;

    /* renamed from: r  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33951r;

    /* renamed from: s  reason: collision with root package name */
    int f33952s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$resolveUsingWebView$3(WebViewResolver webViewResolver, Continuation<? super WebViewResolver$resolveUsingWebView$3> continuation) {
        super(continuation);
        this.f33951r = webViewResolver;
    }

    public final Object invokeSuspend(Object obj) {
        this.f33950q = obj;
        this.f33952s |= Integer.MIN_VALUE;
        return this.f33951r.k((Request) null, (Function1<? super Request, Boolean>) null, this);
    }
}
