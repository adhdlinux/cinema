package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

public final class CancellableKt {
    private static final void a(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.f40263c;
        continuation.resumeWith(Result.b(ResultKt.a(th)));
        throw th;
    }

    public static final void b(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.Companion companion = Result.f40263c;
            DispatchedContinuationKt.c(c2, Result.b(Unit.f40298a), (Function1) null, 2, (Object) null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final <R, T> void c(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r2, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation c2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function2, r2, continuation));
            Result.Companion companion = Result.f40263c;
            DispatchedContinuationKt.b(c2, Result.b(Unit.f40298a), function1);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void d(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        c(function2, obj, continuation, function1);
    }
}
