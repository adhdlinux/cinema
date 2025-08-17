package com.original.tase.helper.webview;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.webview.WebViewDriver$loadUrl$$inlined$launchOnMain$2", f = "WebViewDriver.kt", l = {}, m = "invokeSuspend")
public final class WebViewDriver$loadUrl$$inlined$launchOnMain$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f34036i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebViewDriver f34037j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ String f34038k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewDriver$loadUrl$$inlined$launchOnMain$2(Continuation continuation, WebViewDriver webViewDriver, String str) {
        super(2, continuation);
        this.f34037j = webViewDriver;
        this.f34038k = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewDriver$loadUrl$$inlined$launchOnMain$2(continuation, this.f34037j, this.f34038k);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewDriver$loadUrl$$inlined$launchOnMain$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f34036i == 0) {
            ResultKt.b(obj);
            WebViewDriver$loadUrl$$inlined$launchOnMain$2.super.loadUrl(this.f34038k);
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
