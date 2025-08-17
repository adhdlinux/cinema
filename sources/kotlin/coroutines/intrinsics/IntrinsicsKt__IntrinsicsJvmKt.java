package kotlin.coroutines.intrinsics;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

class IntrinsicsKt__IntrinsicsJvmKt {
    public static <R, T> Continuation<Unit> a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r2, Continuation<? super T> continuation) {
        Intrinsics.f(function2, "<this>");
        Intrinsics.f(continuation, "completion");
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r2, a2);
        }
        CoroutineContext context = a2.getContext();
        if (context == EmptyCoroutineContext.f40358b) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(a2, function2, r2);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(a2, context, function2, r2);
    }

    private static final <T> Continuation<T> b(Continuation<? super T> continuation) {
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.f40358b) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(continuation);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(continuation, context);
    }

    public static <T> Continuation<T> c(Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Continuation<Object> intercepted;
        Intrinsics.f(continuation, "<this>");
        if (continuation instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) continuation;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) {
            return continuation;
        }
        return intercepted;
    }

    public static <R, P, T> Object d(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r2, P p2, Continuation<? super T> continuation) {
        Intrinsics.f(function3, "<this>");
        Intrinsics.f(continuation, "completion");
        return ((Function3) TypeIntrinsics.b(function3, 3)).invoke(r2, p2, b(DebugProbesKt.a(continuation)));
    }
}
