package com.original.tase.helper.http.cloudflare;

import android.content.Context;
import android.webkit.WebView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$Companion$getWebViewUserAgent$1$1", f = "WebViewResolver.kt", l = {124}, m = "invokeSuspend")
final class WebViewResolver$Companion$getWebViewUserAgent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33929i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f33930j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Context f33931k;

    @DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$Companion$getWebViewUserAgent$1$1$1", f = "WebViewResolver.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.original.tase.helper.http.cloudflare.WebViewResolver$Companion$getWebViewUserAgent$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: i  reason: collision with root package name */
        int f33932i;

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, CoroutineScope coroutineScope2, Continuation<? super String> continuation) {
            return new AnonymousClass1(context, continuation).invokeSuspend(Unit.f40298a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.f33932i == 0) {
                ResultKt.b(obj);
                String userAgentString = new WebView(context).getSettings().getUserAgentString();
                WebViewResolver.f33920h.c(userAgentString);
                return userAgentString;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$Companion$getWebViewUserAgent$1$1(Context context, Continuation<? super WebViewResolver$Companion$getWebViewUserAgent$1$1> continuation) {
        super(2, continuation);
        this.f33931k = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebViewResolver$Companion$getWebViewUserAgent$1$1 webViewResolver$Companion$getWebViewUserAgent$1$1 = new WebViewResolver$Companion$getWebViewUserAgent$1$1(this.f33931k, continuation);
        webViewResolver$Companion$getWebViewUserAgent$1$1.f33930j = obj;
        return webViewResolver$Companion$getWebViewUserAgent$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((WebViewResolver$Companion$getWebViewUserAgent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33929i;
        if (i2 == 0) {
            ResultKt.b(obj);
            final Context context = this.f33931k;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f33929i = 1;
            obj = WebViewResolverKt.e((CoroutineScope) this.f33930j, r12, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
