package com.unity3d.services.core.domain.task;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", l = {111}, m = "handleInitializationException")
final class InitializeSDK$handleInitializationException$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$handleInitializationException$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$handleInitializationException$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleInitializationException((InitializationException) null, this);
    }
}
