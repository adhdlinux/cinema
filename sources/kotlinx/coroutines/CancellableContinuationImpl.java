package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40590g;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40591h;

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40592i;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _parentHandle;
    private volatile Object _state = Active.f40586b;

    /* renamed from: e  reason: collision with root package name */
    private final Continuation<T> f40593e;

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f40594f;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        f40590g = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        f40591h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f40592i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public CancellableContinuationImpl(Continuation<? super T> continuation, int i2) {
        super(i2);
        this.f40593e = continuation;
        this.f40594f = continuation.getContext();
    }

    private final DisposableHandle B() {
        Job job = (Job) getContext().get(Job.E0);
        if (job == null) {
            return null;
        }
        DisposableHandle d2 = Job.DefaultImpls.d(job, true, false, new ChildContinuation(this), 2, (Object) null);
        a.a(f40592i, this, (Object) null, d2);
        return d2;
    }

    private final void C(Object obj) {
        boolean z2;
        Object obj2 = obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof Active)) {
                if (obj3 instanceof CancelHandler) {
                    z2 = true;
                } else {
                    z2 = obj3 instanceof Segment;
                }
                if (z2) {
                    G(obj2, obj3);
                } else {
                    boolean z3 = obj3 instanceof CompletedExceptionally;
                    if (z3) {
                        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj3;
                        if (!completedExceptionally.b()) {
                            G(obj2, obj3);
                        }
                        if (obj3 instanceof CancelledContinuation) {
                            Throwable th = null;
                            if (!z3) {
                                completedExceptionally = null;
                            }
                            if (completedExceptionally != null) {
                                th = completedExceptionally.f40605a;
                            }
                            if (obj2 instanceof CancelHandler) {
                                n((CancelHandler) obj2, th);
                                return;
                            }
                            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            p((Segment) obj2, th);
                            return;
                        }
                        return;
                    } else if (obj3 instanceof CompletedContinuation) {
                        CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                        if (completedContinuation.f40600b != null) {
                            G(obj2, obj3);
                        }
                        if (!(obj2 instanceof Segment)) {
                            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                            CancelHandler cancelHandler = (CancelHandler) obj2;
                            if (completedContinuation.c()) {
                                n(cancelHandler, completedContinuation.f40603e);
                                return;
                            }
                            if (a.a(f40591h, this, obj3, CompletedContinuation.b(completedContinuation, (Object) null, cancelHandler, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!(obj2 instanceof Segment)) {
                        Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (a.a(f40591h, this, obj3, new CompletedContinuation(obj3, (CancelHandler) obj2, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else if (a.a(f40591h, this, obj3, obj2)) {
                return;
            }
        }
    }

    private final boolean E() {
        if (DispatchedTaskKt.c(this.f40628d)) {
            Continuation<T> continuation = this.f40593e;
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).p()) {
                return true;
            }
        }
        return false;
    }

    private final CancelHandler F(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void G(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void L(Object obj, int i2, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.c()) {
                        if (function1 != null) {
                            o(function1, cancelledContinuation.f40605a);
                            return;
                        }
                        return;
                    }
                }
                m(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(f40591h, this, obj2, N((NotCompleted) obj2, obj, i2, function1, (Object) null)));
        t();
        u(i2);
    }

    static /* synthetic */ void M(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i2, Function1 function1, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.L(obj, i2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object N(NotCompleted notCompleted, Object obj, int i2, Function1<? super Throwable, Unit> function1, Object obj2) {
        CancelHandler cancelHandler;
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (!DispatchedTaskKt.b(i2) && obj2 == null) {
            return obj;
        }
        if (function1 == null && !(notCompleted instanceof CancelHandler) && obj2 == null) {
            return obj;
        }
        if (notCompleted instanceof CancelHandler) {
            cancelHandler = (CancelHandler) notCompleted;
        } else {
            cancelHandler = null;
        }
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    private final boolean O() {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40590g;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f40590g.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
        return true;
    }

    private final Symbol P(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null || ((CompletedContinuation) obj3).f40602d != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.f40595a;
            }
        } while (!a.a(f40591h, this, obj3, N((NotCompleted) obj3, obj, this.f40628d, function1, obj2)));
        t();
        return CancellableContinuationImplKt.f40595a;
    }

    private final boolean Q() {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40590g;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f40590g.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        return true;
    }

    private final Void m(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void p(Segment<?> segment, Throwable th) {
        boolean z2;
        int i2 = f40590g.get(this) & 536870911;
        if (i2 != 536870911) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                segment.n(i2, th, getContext());
            } catch (Throwable th2) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    private final boolean r(Throwable th) {
        if (!E()) {
            return false;
        }
        Continuation<T> continuation = this.f40593e;
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).q(th);
    }

    private final void t() {
        if (!E()) {
            s();
        }
    }

    private final void u(int i2) {
        if (!O()) {
            DispatchedTaskKt.a(this, i2);
        }
    }

    private final DisposableHandle w() {
        return (DisposableHandle) f40592i.get(this);
    }

    private final String z() {
        Object y2 = y();
        if (y2 instanceof NotCompleted) {
            return "Active";
        }
        if (y2 instanceof CancelledContinuation) {
            return "Cancelled";
        }
        return "Completed";
    }

    public void A() {
        DisposableHandle B = B();
        if (B != null && D()) {
            B.dispose();
            f40592i.set(this, NonDisposableHandle.f40684b);
        }
    }

    public boolean D() {
        return !(y() instanceof NotCompleted);
    }

    /* access modifiers changed from: protected */
    public String H() {
        return "CancellableContinuation";
    }

    public final void I(Throwable th) {
        if (!r(th)) {
            q(th);
            t();
        }
    }

    public final void J() {
        DispatchedContinuation dispatchedContinuation;
        Throwable s2;
        Continuation<T> continuation = this.f40593e;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (s2 = dispatchedContinuation.s(this)) != null) {
            s();
            q(s2);
        }
    }

    public final boolean K() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (!(obj instanceof CompletedContinuation) || ((CompletedContinuation) obj).f40602d == null) {
            f40590g.set(this, 536870911);
            atomicReferenceFieldUpdater.set(this, Active.f40586b);
            return true;
        }
        s();
        return false;
    }

    public void a(Segment<?> segment, int i2) {
        int i3;
        boolean z2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40590g;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) == 536870911) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        C(segment);
    }

    public void b(Function1<? super Throwable, Unit> function1) {
        C(F(function1));
    }

    public void c(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.c()) {
                        Throwable th2 = th;
                        if (a.a(f40591h, this, obj2, CompletedContinuation.b(completedContinuation, (Object) null, (CancelHandler) null, (Function1) null, (Object) null, th, 15, (Object) null))) {
                            completedContinuation.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    Throwable th3 = th;
                    if (a.a(f40591h, this, obj2, new CompletedContinuation(obj2, (CancelHandler) null, (Function1) null, (Object) null, th, 14, (DefaultConstructorMarker) null))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public void d(T t2, Function1<? super Throwable, Unit> function1) {
        L(t2, this.f40628d, function1);
    }

    public Object e(T t2, Object obj, Function1<? super Throwable, Unit> function1) {
        return P(t2, obj, function1);
    }

    public final Continuation<T> f() {
        return this.f40593e;
    }

    public void g(CoroutineDispatcher coroutineDispatcher, T t2) {
        DispatchedContinuation dispatchedContinuation;
        int i2;
        Continuation<T> continuation = this.f40593e;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.f40728e;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i2 = 4;
        } else {
            i2 = this.f40628d;
        }
        M(this, t2, i2, (Function1) null, 4, (Object) null);
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f40593e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f40594f;
    }

    public void h(Object obj) {
        u(this.f40628d);
    }

    public Throwable i(Object obj) {
        Throwable i2 = super.i(obj);
        if (i2 != null) {
            return i2;
        }
        return null;
    }

    public <T> T j(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).f40599a : obj;
    }

    public Object l() {
        return y();
    }

    public final void n(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.a(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean q(Throwable th) {
        Object obj;
        boolean z2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40591h;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z2 = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            if ((obj instanceof CancelHandler) || (obj instanceof Segment)) {
                z2 = true;
            }
        } while (!a.a(f40591h, this, obj, new CancelledContinuation(this, th, z2)));
        NotCompleted notCompleted = (NotCompleted) obj;
        if (notCompleted instanceof CancelHandler) {
            n((CancelHandler) obj, th);
        } else if (notCompleted instanceof Segment) {
            p((Segment) obj, th);
        }
        t();
        u(this.f40628d);
        return true;
    }

    public void resumeWith(Object obj) {
        M(this, CompletionStateKt.c(obj, this), this.f40628d, (Function1) null, 4, (Object) null);
    }

    public final void s() {
        DisposableHandle w2 = w();
        if (w2 != null) {
            w2.dispose();
            f40592i.set(this, NonDisposableHandle.f40684b);
        }
    }

    public String toString() {
        return H() + '(' + DebugStringsKt.c(this.f40593e) + "){" + z() + "}@" + DebugStringsKt.b(this);
    }

    public Throwable v(Job job) {
        return job.s();
    }

    public final Object x() {
        Job job;
        boolean E = E();
        if (Q()) {
            if (w() == null) {
                B();
            }
            if (E) {
                J();
            }
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        if (E) {
            J();
        }
        Object y2 = y();
        if (y2 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) y2).f40605a;
        } else if (!DispatchedTaskKt.b(this.f40628d) || (job = (Job) getContext().get(Job.E0)) == null || job.isActive()) {
            return j(y2);
        } else {
            CancellationException s2 = job.s();
            c(y2, s2);
            throw s2;
        }
    }

    public final Object y() {
        return f40591h.get(this);
    }
}
