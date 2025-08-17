package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 extends RestrictedContinuationImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(Continuation<? super T> continuation) {
        super(continuation);
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        ResultKt.b(obj);
        return obj;
    }
}
