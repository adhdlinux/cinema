package com.unity3d.services.core.domain.task;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2$success$1", f = "InitializeStateNetworkError.kt", l = {79}, m = "invokeSuspend")
final class InitializeStateNetworkError$doWork$2$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2$success$1(InitializeStateNetworkError initializeStateNetworkError, Continuation<? super InitializeStateNetworkError$doWork$2$success$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateNetworkError;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateNetworkError$doWork$2$success$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateNetworkError$doWork$2$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            InitializeStateNetworkError initializeStateNetworkError = this.this$0;
            this.L$0 = initializeStateNetworkError;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);
            cancellableContinuationImpl.A();
            initializeStateNetworkError.startListening(cancellableContinuationImpl);
            Object x2 = cancellableContinuationImpl.x();
            if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
                DebugProbesKt.c(this);
            }
            if (x2 == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            InitializeStateNetworkError initializeStateNetworkError2 = (InitializeStateNetworkError) this.L$0;
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f40298a;
    }
}
