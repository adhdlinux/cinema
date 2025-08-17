package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1", f = "InitializeSDK.kt", l = {86}, m = "invokeSuspend")
final class InitializeSDK$doWork$2$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $configResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2$webViewData$1(InitializeSDK initializeSDK, Object obj, Continuation<? super InitializeSDK$doWork$2$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
        this.$configResult = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2$webViewData$1 initializeSDK$doWork$2$webViewData$1 = new InitializeSDK$doWork$2$webViewData$1(this.this$0, this.$configResult, continuation);
        initializeSDK$doWork$2$webViewData$1.L$0 = obj;
        return initializeSDK$doWork$2$webViewData$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeSDK initializeSDK = this.this$0;
            Object obj2 = this.$configResult;
            Result.Companion companion = Result.f40263c;
            InitializeStateLoadWeb access$getInitializeStateLoadWeb$p = initializeSDK.initializeStateLoadWeb;
            ResultKt.b(obj2);
            InitializeStateLoadWeb.Params params = new InitializeStateLoadWeb.Params((Configuration) obj2);
            this.label = 1;
            obj = access$getInitializeStateLoadWeb$p.invoke(params, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f40263c;
                Result.b(ResultKt.a(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.b((InitializeStateLoadWeb.LoadWebResult) obj);
        return Unit.f40298a;
    }
}
