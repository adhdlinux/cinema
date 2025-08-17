package kotlin.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class ContinuationKt {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r2, Continuation<? super T> continuation) {
        Intrinsics.f(function2, "<this>");
        Intrinsics.f(continuation, "completion");
        Continuation c2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function2, r2, continuation));
        Result.Companion companion = Result.f40263c;
        c2.resumeWith(Result.b(Unit.f40298a));
    }
}
