package com.original.tase.helper.http.cloudflare;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolverKt$main$1", f = "WebViewResolver.kt", l = {45}, m = "invokeSuspend")
final class WebViewResolverKt$main$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33993i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f33994j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ T f33995k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolverKt$main$1(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, T t2, Continuation<? super WebViewResolverKt$main$1> continuation) {
        super(2, continuation);
        this.f33994j = function2;
        this.f33995k = t2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolverKt$main$1(this.f33994j, this.f33995k, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewResolverKt$main$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33993i;
        if (i2 == 0) {
            ResultKt.b(obj);
            Function2<T, Continuation<? super Unit>, Object> function2 = this.f33994j;
            T t2 = this.f33995k;
            this.f33993i = 1;
            if (function2.invoke(t2, this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f40298a;
    }
}
