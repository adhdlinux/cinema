package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

public class MutexImpl extends SemaphoreImpl implements Mutex {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f40841i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    /* renamed from: h  reason: collision with root package name */
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> f40842h;
    private volatile Object owner;

    private final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        /* renamed from: b  reason: collision with root package name */
        public final CancellableContinuationImpl<Unit> f40843b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f40844c;

        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object obj) {
            this.f40843b = cancellableContinuationImpl;
            this.f40844c = obj;
        }

        public void a(Segment<?> segment, int i2) {
            this.f40843b.a(segment, i2);
        }

        public void b(Function1<? super Throwable, Unit> function1) {
            this.f40843b.b(function1);
        }

        /* renamed from: c */
        public void d(Unit unit, Function1<? super Throwable, Unit> function1) {
            MutexImpl.f40841i.set(MutexImpl.this, this.f40844c);
            this.f40843b.d(unit, new MutexImpl$CancellableContinuationWithOwner$resume$2(MutexImpl.this, this));
        }

        /* renamed from: f */
        public void g(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.f40843b.g(coroutineDispatcher, unit);
        }

        public CoroutineContext getContext() {
            return this.f40843b.getContext();
        }

        public void h(Object obj) {
            this.f40843b.h(obj);
        }

        /* renamed from: i */
        public Object e(Unit unit, Object obj, Function1<? super Throwable, Unit> function1) {
            Object e2 = this.f40843b.e(unit, obj, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl.this, this));
            if (e2 != null) {
                MutexImpl.f40841i.set(MutexImpl.this, this.f40844c);
            }
            return e2;
        }

        public void resumeWith(Object obj) {
            this.f40843b.resumeWith(obj);
        }
    }

    public MutexImpl(boolean z2) {
        super(1, z2 ? 1 : 0);
        Symbol symbol;
        if (z2) {
            symbol = null;
        } else {
            symbol = MutexKt.f40853a;
        }
        this.owner = symbol;
        this.f40842h = new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
    }

    static /* synthetic */ Object o(MutexImpl mutexImpl, Object obj, Continuation<? super Unit> continuation) {
        if (mutexImpl.q(obj)) {
            return Unit.f40298a;
        }
        Object p2 = mutexImpl.p(obj, continuation);
        if (p2 == IntrinsicsKt__IntrinsicsKt.e()) {
            return p2;
        }
        return Unit.f40298a;
    }

    private final Object p(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl b2 = CancellableContinuationKt.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        try {
            c(new CancellableContinuationWithOwner(b2, obj));
            Object x2 = b2.x();
            if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
                DebugProbesKt.c(continuation);
            }
            if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
                return x2;
            }
            return Unit.f40298a;
        } catch (Throwable th) {
            b2.J();
            throw th;
        }
    }

    private final int r(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            if (m(obj)) {
                return 2;
            }
            if (n()) {
                return 1;
            }
        }
        f40841i.set(this, obj);
        return 0;
    }

    public Object a(Object obj, Continuation<? super Unit> continuation) {
        return o(this, obj, continuation);
    }

    public void b(Object obj) {
        boolean z2;
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40841i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != MutexKt.f40853a) {
                if (obj2 == obj || obj == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (a.a(atomicReferenceFieldUpdater, this, obj2, MutexKt.f40853a)) {
                    h();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean m(Object obj) {
        while (n()) {
            Object obj2 = f40841i.get(this);
            if (obj2 != MutexKt.f40853a) {
                if (obj2 == obj) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean n() {
        return g() == 0;
    }

    public boolean q(Object obj) {
        int r2 = r(obj);
        if (r2 == 0) {
            return true;
        }
        if (r2 == 1) {
            return false;
        }
        if (r2 != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.b(this) + "[isLocked=" + n() + ",owner=" + f40841i.get(this) + ']';
    }
}
