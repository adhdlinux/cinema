package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class CompletionStateKt {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (!(obj instanceof CompletedExceptionally)) {
            return Result.b(obj);
        }
        Result.Companion companion = Result.f40263c;
        return Result.b(ResultKt.a(((CompletedExceptionally) obj).f40605a));
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            return new CompletedExceptionally(e2, false, 2, (DefaultConstructorMarker) null);
        }
        if (function1 != null) {
            return new CompletedWithCancellation(obj, function1);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable e2 = Result.e(obj);
        if (e2 == null) {
            return obj;
        }
        return new CompletedExceptionally(e2, false, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
