package com.unity3d.services.core.domain.task;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.MetricTask", f = "MetricTask.kt", l = {24}, m = "invoke$suspendImpl")
final class MetricTask$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetricTask<P, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MetricTask$invoke$1(MetricTask<? super P, R> metricTask, Continuation<? super MetricTask$invoke$1> continuation) {
        super(continuation);
        this.this$0 = metricTask;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MetricTask.invoke$suspendImpl(this.this$0, null, this);
    }
}
