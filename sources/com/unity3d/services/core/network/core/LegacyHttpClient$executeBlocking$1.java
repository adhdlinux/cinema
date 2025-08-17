package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1", f = "LegacyHttpClient.kt", l = {26}, m = "invokeSuspend")
final class LegacyHttpClient$executeBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ LegacyHttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyHttpClient$executeBlocking$1(LegacyHttpClient legacyHttpClient, HttpRequest httpRequest, Continuation<? super LegacyHttpClient$executeBlocking$1> continuation) {
        super(2, continuation);
        this.this$0 = legacyHttpClient;
        this.$request = httpRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyHttpClient$executeBlocking$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((LegacyHttpClient$executeBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            LegacyHttpClient legacyHttpClient = this.this$0;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            obj = legacyHttpClient.execute(httpRequest, this);
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
