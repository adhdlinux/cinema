package com.original.tase.helper.http.cloudflare;

import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$intercept$1", f = "WebViewResolver.kt", l = {137}, m = "invokeSuspend")
final class WebViewResolver$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33934i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33935j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Request f33936k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Interceptor.Chain f33937l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$intercept$1(WebViewResolver webViewResolver, Request request, Interceptor.Chain chain, Continuation<? super WebViewResolver$intercept$1> continuation) {
        super(2, continuation);
        this.f33935j = webViewResolver;
        this.f33936k = request;
        this.f33937l = chain;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolver$intercept$1(this.f33935j, this.f33936k, this.f33937l, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response> continuation) {
        return ((WebViewResolver$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33934i;
        if (i2 == 0) {
            ResultKt.b(obj);
            WebViewResolver webViewResolver = this.f33935j;
            Request request = this.f33936k;
            this.f33934i = 1;
            obj = WebViewResolver.m(webViewResolver, request, (Function1) null, this, 2, (Object) null);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Request request2 = (Request) ((Pair) obj).c();
        Interceptor.Chain chain = this.f33937l;
        if (request2 == null) {
            request2 = this.f33936k;
        }
        return chain.proceed(request2);
    }
}
