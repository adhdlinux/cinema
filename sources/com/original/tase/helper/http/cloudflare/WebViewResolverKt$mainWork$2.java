package com.original.tase.helper.http.cloudflare;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolverKt$mainWork$2", f = "WebViewResolver.kt", l = {52}, m = "invokeSuspend")
final class WebViewResolverKt$mainWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33996i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f33997j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function3<CoroutineScope, V, Continuation<? super T>, Object> f33998k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ V f33999l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolverKt$mainWork$2(Function3<? super CoroutineScope, ? super V, ? super Continuation<? super T>, ? extends Object> function3, V v2, Continuation<? super WebViewResolverKt$mainWork$2> continuation) {
        super(2, continuation);
        this.f33998k = function3;
        this.f33999l = v2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebViewResolverKt$mainWork$2 webViewResolverKt$mainWork$2 = new WebViewResolverKt$mainWork$2(this.f33998k, this.f33999l, continuation);
        webViewResolverKt$mainWork$2.f33997j = obj;
        return webViewResolverKt$mainWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((WebViewResolverKt$mainWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33996i;
        if (i2 == 0) {
            ResultKt.b(obj);
            Function3<CoroutineScope, V, Continuation<? super T>, Object> function3 = this.f33998k;
            V v2 = this.f33999l;
            this.f33996i = 1;
            obj = function3.invoke((CoroutineScope) this.f33997j, v2, this);
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
