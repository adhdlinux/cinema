package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2", f = "InitializeStateConfig.kt", l = {26}, m = "invokeSuspend")
final class InitializeStateConfig$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateConfig.Params $params;
    int label;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfig$doWork$2(InitializeStateConfig.Params params, InitializeStateConfig initializeStateConfig, Continuation<? super InitializeStateConfig$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateConfig;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateConfig$doWork$2(this.$params, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateConfig$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
            Configuration configuration = new Configuration(SdkProperties.getConfigUrl(), this.$params.getConfig().getExperimentsReader());
            InitializeStateConfigWithLoader access$getInitializeStateConfigWithLoader$p = this.this$0.initializeStateConfigWithLoader;
            InitializeStateConfigWithLoader.Params params = new InitializeStateConfigWithLoader.Params(configuration);
            this.label = 1;
            obj = access$getInitializeStateConfigWithLoader$p.invoke((BaseParams) params, (Continuation) this);
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
