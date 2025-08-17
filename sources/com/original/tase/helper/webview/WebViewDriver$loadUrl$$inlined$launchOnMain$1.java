package com.original.tase.helper.webview;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.webview.WebViewDriver$loadUrl$$inlined$launchOnMain$1", f = "WebViewDriver.kt", l = {}, m = "invokeSuspend")
public final class WebViewDriver$loadUrl$$inlined$launchOnMain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f34032i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebViewDriver f34033j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ String f34034k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Map f34035l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewDriver$loadUrl$$inlined$launchOnMain$1(Continuation continuation, WebViewDriver webViewDriver, String str, Map map) {
        super(2, continuation);
        this.f34033j = webViewDriver;
        this.f34034k = str;
        this.f34035l = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewDriver$loadUrl$$inlined$launchOnMain$1(continuation, this.f34033j, this.f34034k, this.f34035l);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewDriver$loadUrl$$inlined$launchOnMain$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f34032i == 0) {
            ResultKt.b(obj);
            WebViewDriver$loadUrl$$inlined$launchOnMain$1.super.loadUrl(this.f34034k, this.f34035l);
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
