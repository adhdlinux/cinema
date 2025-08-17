package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewData$1", f = "InitializeStateLoadWeb.kt", l = {61}, m = "invokeSuspend")
final class InitializeStateLoadWeb$doWork$2$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2$webViewData$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super InitializeStateLoadWeb$doWork$2$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadWeb$doWork$2$webViewData$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((InitializeStateLoadWeb$doWork$2$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpClient access$getHttpClient$p = this.this$0.httpClient;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            obj = access$getHttpClient$p.execute(httpRequest, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((HttpResponse) obj).getBody().toString();
    }
}
