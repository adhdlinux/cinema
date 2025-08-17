package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", f = "InitializeStateNetworkError.kt", l = {37}, m = "invokeSuspend")
final class InitializeStateNetworkError$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InitializeStateNetworkError.Params $params;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2(InitializeStateNetworkError initializeStateNetworkError, InitializeStateNetworkError.Params params, Continuation<? super InitializeStateNetworkError$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateNetworkError;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateNetworkError$doWork$2(this.this$0, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateNetworkError$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            this.this$0.maximumConnectedEvents = this.$params.getConfig().getMaximumConnectedEvents();
            this.this$0.connectedEventThreshold = this.$params.getConfig().getConnectedEventThreshold();
            long networkErrorTimeout = this.$params.getConfig().getNetworkErrorTimeout();
            InitializeStateNetworkError$doWork$2$success$1 initializeStateNetworkError$doWork$2$success$1 = new InitializeStateNetworkError$doWork$2$success$1(this.this$0, (Continuation<? super InitializeStateNetworkError$doWork$2$success$1>) null);
            this.label = 1;
            obj = TimeoutKt.d(networkErrorTimeout, initializeStateNetworkError$doWork$2$success$1, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Unit) obj) != null) {
            return Unit.f40298a;
        }
        ConnectivityMonitor.removeListener(this.this$0);
        throw new Exception("No connected events within the timeout!");
    }
}
