package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class UndispatchedKt {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r2, Continuation<? super T> continuation) {
        CoroutineContext context;
        Object c2;
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            context = continuation.getContext();
            c2 = ThreadContextKt.c(context, (Object) null);
            Object invoke = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r2, a2);
            ThreadContextKt.a(context, c2);
            if (invoke != IntrinsicsKt__IntrinsicsKt.e()) {
                a2.resumeWith(Result.b(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.f40263c;
            a2.resumeWith(Result.b(ResultKt.a(th)));
        }
    }

    public static final <T, R> Object b(ScopeCoroutine<? super T> scopeCoroutine, R r2, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        try {
            obj = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r2, scopeCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.e()) {
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        Object V = scopeCoroutine.V(obj);
        if (V == JobSupportKt.f40677b) {
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        if (!(V instanceof CompletedExceptionally)) {
            return JobSupportKt.h(V);
        }
        throw ((CompletedExceptionally) V).f40605a;
    }

    public static final <T, R> Object c(ScopeCoroutine<? super T> scopeCoroutine, R r2, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        boolean z2 = false;
        try {
            obj = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r2, scopeCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.e()) {
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        Object V = scopeCoroutine.V(obj);
        if (V == JobSupportKt.f40677b) {
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        if (V instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) V).f40605a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).f40687b != scopeCoroutine) {
                z2 = true;
            }
            if (z2) {
                throw th2;
            } else if (obj instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) obj).f40605a;
            }
        } else {
            obj = JobSupportKt.h(V);
        }
        return obj;
    }
}
