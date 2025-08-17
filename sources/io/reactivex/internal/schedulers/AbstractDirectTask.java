package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {

    /* renamed from: d  reason: collision with root package name */
    protected static final FutureTask<Void> f39938d;

    /* renamed from: e  reason: collision with root package name */
    protected static final FutureTask<Void> f39939e;

    /* renamed from: b  reason: collision with root package name */
    protected final Runnable f39940b;

    /* renamed from: c  reason: collision with root package name */
    protected Thread f39941c;

    static {
        Runnable runnable = Functions.f38341b;
        f39938d = new FutureTask<>(runnable, (Object) null);
        f39939e = new FutureTask<>(runnable, (Object) null);
    }

    AbstractDirectTask(Runnable runnable) {
        this.f39940b = runnable;
    }

    public final void a(Future<?> future) {
        Future future2;
        boolean z2;
        do {
            future2 = (Future) get();
            if (future2 != f39938d) {
                if (future2 == f39939e) {
                    if (this.f39941c != Thread.currentThread()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    future.cancel(z2);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        boolean z2;
        Future future = (Future) get();
        if (future != f39938d && future != (futureTask = f39939e) && compareAndSet(future, futureTask) && future != null) {
            if (this.f39941c != Thread.currentThread()) {
                z2 = true;
            } else {
                z2 = false;
            }
            future.cancel(z2);
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future == f39938d || future == f39939e) {
            return true;
        }
        return false;
    }
}
