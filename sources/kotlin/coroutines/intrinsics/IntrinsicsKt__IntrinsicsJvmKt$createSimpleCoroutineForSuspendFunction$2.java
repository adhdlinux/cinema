package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 extends ContinuationImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        super(continuation, coroutineContext);
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        ResultKt.b(obj);
        return obj;
    }
}
