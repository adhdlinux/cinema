package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2", f = "InitializeStateComplete.kt", l = {}, m = "invokeSuspend")
final class InitializeStateComplete$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InitializeStateComplete.Params $params;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateComplete$doWork$2(InitializeStateComplete.Params params, Continuation<? super InitializeStateComplete$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateComplete$doWork$2(this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateComplete$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            Class[] moduleConfigurationList = this.$params.getConfig().getModuleConfigurationList();
            Intrinsics.e(moduleConfigurationList, "params.config.moduleConfigurationList");
            for (Class moduleConfiguration : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration2 = this.$params.getConfig().getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    Boxing.a(moduleConfiguration2.initCompleteState(this.$params.getConfig()));
                }
            }
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
