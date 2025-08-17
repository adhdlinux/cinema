package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40737h = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f40738c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40739d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Delay f40740e;

    /* renamed from: f  reason: collision with root package name */
    private final LockFreeTaskQueue<Runnable> f40741f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f40742g;
    private volatile int runningWorkers;

    private final class Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Runnable f40743b;

        public Worker(Runnable runnable) {
            this.f40743b = runnable;
        }

        public void run() {
            int i2 = 0;
            while (true) {
                try {
                    this.f40743b.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.f40358b, th);
                }
                Runnable s02 = LimitedDispatcher.this.t0();
                if (s02 != null) {
                    this.f40743b = s02;
                    i2++;
                    if (i2 >= 16 && LimitedDispatcher.this.f40738c.p0(LimitedDispatcher.this)) {
                        LimitedDispatcher.this.f40738c.o0(LimitedDispatcher.this, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i2) {
        Delay delay;
        this.f40738c = coroutineDispatcher;
        this.f40739d = i2;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.f40740e = delay == null ? DefaultExecutorKt.a() : delay;
        this.f40741f = new LockFreeTaskQueue<>(false);
        this.f40742g = new Object();
    }

    /* access modifiers changed from: private */
    public final Runnable t0() {
        while (true) {
            Runnable d2 = this.f40741f.d();
            if (d2 != null) {
                return d2;
            }
            synchronized (this.f40742g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40737h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f40741f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean u0() {
        synchronized (this.f40742g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40737h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f40739d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    public DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f40740e.A(j2, runnable, coroutineContext);
    }

    public void k(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f40740e.k(j2, cancellableContinuation);
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable t02;
        this.f40741f.a(runnable);
        if (f40737h.get(this) < this.f40739d && u0() && (t02 = t0()) != null) {
            this.f40738c.o0(this, new Worker(t02));
        }
    }
}
