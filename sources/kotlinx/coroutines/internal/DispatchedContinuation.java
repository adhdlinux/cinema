package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40727i = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: e  reason: collision with root package name */
    public final CoroutineDispatcher f40728e;

    /* renamed from: f  reason: collision with root package name */
    public final Continuation<T> f40729f;

    /* renamed from: g  reason: collision with root package name */
    public Object f40730g = DispatchedContinuationKt.f40732a;

    /* renamed from: h  reason: collision with root package name */
    public final Object f40731h = ThreadContextKt.b(getContext());

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f40728e = coroutineDispatcher;
        this.f40729f = continuation;
    }

    private final CancellableContinuationImpl<?> o() {
        Object obj = f40727i.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    public void c(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).f40607b.invoke(th);
        }
    }

    public Continuation<T> f() {
        return this;
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f40729f;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f40729f.getContext();
    }

    public Object l() {
        Object obj = this.f40730g;
        this.f40730g = DispatchedContinuationKt.f40732a;
        return obj;
    }

    public final void m() {
        do {
        } while (f40727i.get(this) == DispatchedContinuationKt.f40733b);
    }

    public final CancellableContinuationImpl<T> n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40727i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f40727i.set(this, DispatchedContinuationKt.f40733b);
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (a.a(f40727i, this, obj, DispatchedContinuationKt.f40733b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != DispatchedContinuationKt.f40733b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean p() {
        if (f40727i.get(this) != null) {
            return true;
        }
        return false;
    }

    public final boolean q(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40727i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = DispatchedContinuationKt.f40733b;
            if (Intrinsics.a(obj, symbol)) {
                if (a.a(f40727i, this, symbol, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f40727i, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        m();
        CancellableContinuationImpl<?> o2 = o();
        if (o2 != null) {
            o2.s();
        }
    }

    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object c2;
        CoroutineContext context2 = this.f40729f.getContext();
        Object d2 = CompletionStateKt.d(obj, (Function1) null, 1, (Object) null);
        if (this.f40728e.p0(context2)) {
            this.f40730g = d2;
            this.f40628d = 0;
            this.f40728e.o0(context2, this);
            return;
        }
        EventLoop b2 = ThreadLocalEventLoop.f40685a.b();
        if (b2.y0()) {
            this.f40730g = d2;
            this.f40628d = 0;
            b2.u0(this);
            return;
        }
        b2.w0(true);
        try {
            context = getContext();
            c2 = ThreadContextKt.c(context, this.f40731h);
            this.f40729f.resumeWith(obj);
            Unit unit = Unit.f40298a;
            ThreadContextKt.a(context, c2);
            do {
            } while (b2.B0());
        } catch (Throwable th) {
            try {
                k(th, (Throwable) null);
            } catch (Throwable th2) {
                b2.r0(true);
                throw th2;
            }
        }
        b2.r0(true);
    }

    public final Throwable s(CancellableContinuation<?> cancellableContinuation) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40727i;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = DispatchedContinuationKt.f40733b;
            if (obj != symbol) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(f40727i, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!a.a(f40727i, this, symbol, cancellableContinuation));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f40728e + ", " + DebugStringsKt.c(this.f40729f) + ']';
    }
}
