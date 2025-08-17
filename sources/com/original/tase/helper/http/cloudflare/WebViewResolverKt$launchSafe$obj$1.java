package com.original.tase.helper.http.cloudflare;

import com.original.tase.Logger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolverKt$launchSafe$obj$1", f = "WebViewResolver.kt", l = {63}, m = "invokeSuspend")
final class WebViewResolverKt$launchSafe$obj$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33990i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f33991j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f33992k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolverKt$launchSafe$obj$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super WebViewResolverKt$launchSafe$obj$1> continuation) {
        super(2, continuation);
        this.f33992k = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebViewResolverKt$launchSafe$obj$1 webViewResolverKt$launchSafe$obj$1 = new WebViewResolverKt$launchSafe$obj$1(this.f33992k, continuation);
        webViewResolverKt$launchSafe$obj$1.f33991j = obj;
        return webViewResolverKt$launchSafe$obj$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewResolverKt$launchSafe$obj$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33990i;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f33991j;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f33992k;
            this.f33990i = 1;
            if (function2.invoke(coroutineScope, this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f40298a;
    }
}
