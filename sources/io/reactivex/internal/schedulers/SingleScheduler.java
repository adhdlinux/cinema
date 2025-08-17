package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f40020d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f40021e;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f40022b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f40023c;

    static final class ScheduledWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        final ScheduledExecutorService f40024b;

        /* renamed from: c  reason: collision with root package name */
        final CompositeDisposable f40025c = new CompositeDisposable();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f40026d;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f40024b = scheduledExecutorService;
        }

        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            Future future;
            if (this.f40026d) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), this.f40025c);
            this.f40025c.b(scheduledRunnable);
            if (j2 <= 0) {
                try {
                    future = this.f40024b.submit(scheduledRunnable);
                } catch (RejectedExecutionException e2) {
                    dispose();
                    RxJavaPlugins.s(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f40024b.schedule(scheduledRunnable, j2, timeUnit);
            }
            scheduledRunnable.a(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f40026d) {
                this.f40026d = true;
                this.f40025c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f40026d;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f40021e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f40020d);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.a(threadFactory);
    }

    public Scheduler.Worker a() {
        return new ScheduledWorker(this.f40023c.get());
    }

    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        if (j2 <= 0) {
            try {
                future = this.f40023c.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.s(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f40023c.get().schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public Disposable e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable u2 = RxJavaPlugins.u(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f40023c.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(u2, scheduledExecutorService);
            if (j2 <= 0) {
                try {
                    future = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.s(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(instantPeriodicTask, j2, timeUnit);
            }
            instantPeriodicTask.c(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u2);
        try {
            scheduledDirectPeriodicTask.a(this.f40023c.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f40023c = atomicReference;
        this.f40022b = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }
}
