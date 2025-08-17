package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class DispatchedTaskKt {
    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i2) {
        boolean z2;
        Continuation<? super T> f2 = dispatchedTask.f();
        if (i2 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || !(f2 instanceof DispatchedContinuation) || b(i2) != b(dispatchedTask.f40628d)) {
            d(dispatchedTask, f2, z2);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) f2).f40728e;
        CoroutineContext context = f2.getContext();
        if (coroutineDispatcher.p0(context)) {
            coroutineDispatcher.o0(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z2) {
        Object obj;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        Object l2 = dispatchedTask.l();
        Throwable i2 = dispatchedTask.i(l2);
        if (i2 != null) {
            Result.Companion companion = Result.f40263c;
            obj = ResultKt.a(i2);
        } else {
            Result.Companion companion2 = Result.f40263c;
            obj = dispatchedTask.j(l2);
        }
        Object b2 = Result.b(obj);
        if (z2) {
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.f40729f;
            Object obj2 = dispatchedContinuation.f40731h;
            CoroutineContext context = continuation2.getContext();
            Object c2 = ThreadContextKt.c(context, obj2);
            if (c2 != ThreadContextKt.f40773a) {
                undispatchedCoroutine = CoroutineContextKt.g(continuation2, context, c2);
            } else {
                undispatchedCoroutine = null;
            }
            try {
                dispatchedContinuation.f40729f.resumeWith(b2);
                Unit unit = Unit.f40298a;
            } finally {
                if (undispatchedCoroutine == null || undispatchedCoroutine.y0()) {
                    ThreadContextKt.a(context, c2);
                }
            }
        } else {
            continuation.resumeWith(b2);
        }
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        EventLoop b2 = ThreadLocalEventLoop.f40685a.b();
        if (b2.y0()) {
            b2.u0(dispatchedTask);
            return;
        }
        b2.w0(true);
        try {
            d(dispatchedTask, dispatchedTask.f(), true);
            do {
            } while (b2.B0());
        } catch (Throwable th) {
            b2.r0(true);
            throw th;
        }
        b2.r0(true);
    }
}
