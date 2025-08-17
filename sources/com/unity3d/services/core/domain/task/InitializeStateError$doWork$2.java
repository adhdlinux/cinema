package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateError$doWork$2", f = "InitializeStateError.kt", l = {}, m = "invokeSuspend")
final class InitializeStateError$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InitializeStateError.Params $params;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateError$doWork$2(InitializeStateError.Params params, Continuation<? super InitializeStateError$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateError$doWork$2(this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateError$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            DeviceLog.error("Unity Ads init: halting init in " + this.$params.getErrorState().getMetricName() + ": " + this.$params.getException().getMessage());
            Class[] moduleConfigurationList = this.$params.getConfig().getModuleConfigurationList();
            if (moduleConfigurationList == null) {
                moduleConfigurationList = new Class[0];
            }
            for (Class moduleConfiguration : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration2 = this.$params.getConfig().getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    Boxing.a(moduleConfiguration2.initErrorState(this.$params.getConfig(), this.$params.getErrorState(), this.$params.getException().getMessage()));
                }
            }
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
