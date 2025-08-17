package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40627f = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    private final boolean A0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40627f;
        do {
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f40627f.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean z0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40627f;
        do {
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f40627f.compareAndSet(this, 0, 2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void n(Object obj) {
        u0(obj);
    }

    /* access modifiers changed from: protected */
    public void u0(Object obj) {
        if (!z0()) {
            DispatchedContinuationKt.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f40768e), CompletionStateKt.a(obj, this.f40768e), (Function1) null, 2, (Object) null);
        }
    }

    public final Object y0() {
        if (A0()) {
            return IntrinsicsKt__IntrinsicsKt.e();
        }
        Object h2 = JobSupportKt.h(O());
        if (!(h2 instanceof CompletedExceptionally)) {
            return h2;
        }
        throw ((CompletedExceptionally) h2).f40605a;
    }
}
