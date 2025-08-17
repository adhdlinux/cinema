package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3 extends RestrictedContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    private int f40364i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2 f40365j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Object f40366k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(Continuation continuation, Function2 function2, Object obj) {
        super(continuation);
        this.f40365j = function2;
        this.f40366k = obj;
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        int i2 = this.f40364i;
        if (i2 == 0) {
            this.f40364i = 1;
            ResultKt.b(obj);
            Intrinsics.d(this.f40365j, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
            return ((Function2) TypeIntrinsics.b(this.f40365j, 2)).invoke(this.f40366k, this);
        } else if (i2 == 1) {
            this.f40364i = 2;
            ResultKt.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
