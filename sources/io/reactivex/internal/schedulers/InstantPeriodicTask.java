package io.reactivex.internal.schedulers;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {

    /* renamed from: g  reason: collision with root package name */
    static final FutureTask<Void> f39977g = new FutureTask<>(Functions.f38341b, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    final Runnable f39978b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f39979c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<Future<?>> f39980d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    final ExecutorService f39981e;

    /* renamed from: f  reason: collision with root package name */
    Thread f39982f;

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f39978b = runnable;
        this.f39981e = executorService;
    }

    /* renamed from: b */
    public Void call() throws Exception {
        this.f39982f = Thread.currentThread();
        try {
            this.f39978b.run();
            d(this.f39981e.submit(this));
            this.f39982f = null;
        } catch (Throwable th) {
            this.f39982f = null;
            RxJavaPlugins.s(th);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c(Future<?> future) {
        Future future2;
        boolean z2;
        do {
            future2 = this.f39980d.get();
            if (future2 == f39977g) {
                if (this.f39982f != Thread.currentThread()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                future.cancel(z2);
                return;
            }
        } while (!f.a(this.f39980d, future2, future));
    }

    /* access modifiers changed from: package-private */
    public void d(Future<?> future) {
        Future future2;
        boolean z2;
        do {
            future2 = this.f39979c.get();
            if (future2 == f39977g) {
                if (this.f39982f != Thread.currentThread()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                future.cancel(z2);
                return;
            }
        } while (!f.a(this.f39979c, future2, future));
    }

    public void dispose() {
        boolean z2;
        AtomicReference<Future<?>> atomicReference = this.f39980d;
        Future future = f39977g;
        Future andSet = atomicReference.getAndSet(future);
        boolean z3 = true;
        if (!(andSet == null || andSet == future)) {
            if (this.f39982f != Thread.currentThread()) {
                z2 = true;
            } else {
                z2 = false;
            }
            andSet.cancel(z2);
        }
        Future andSet2 = this.f39979c.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f39982f == Thread.currentThread()) {
                z3 = false;
            }
            andSet2.cancel(z3);
        }
    }

    public boolean isDisposed() {
        return this.f39980d.get() == f39977g;
    }
}
