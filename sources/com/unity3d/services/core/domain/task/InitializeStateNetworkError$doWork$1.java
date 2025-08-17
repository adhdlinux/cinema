package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError", f = "InitializeStateNetworkError.kt", l = {32}, m = "doWork")
final class InitializeStateNetworkError$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$1(InitializeStateNetworkError initializeStateNetworkError, Continuation<? super InitializeStateNetworkError$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateNetworkError;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork((InitializeStateNetworkError.Params) null, (Continuation<? super Unit>) this);
    }
}
