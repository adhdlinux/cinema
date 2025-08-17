package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker {

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f40004b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f40005c;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f40004b = SchedulerPoolFactory.a(threadFactory);
    }

    public Disposable b(Runnable runnable) {
        return c(runnable, 0, (TimeUnit) null);
    }

    public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (this.f40005c) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j2, timeUnit, (DisposableContainer) null);
    }

    public void dispose() {
        if (!this.f40005c) {
            this.f40005c = true;
            this.f40004b.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable runnable, long j2, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j2 <= 0) {
            try {
                future = this.f40004b.submit(scheduledRunnable);
            } catch (RejectedExecutionException e2) {
                if (disposableContainer != null) {
                    disposableContainer.a(scheduledRunnable);
                }
                RxJavaPlugins.s(e2);
            }
        } else {
            future = this.f40004b.schedule(scheduledRunnable, j2, timeUnit);
        }
        scheduledRunnable.a(future);
        return scheduledRunnable;
    }

    public Disposable f(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        if (j2 <= 0) {
            try {
                future = this.f40004b.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.s(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f40004b.schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public Disposable g(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable u2 = RxJavaPlugins.u(runnable);
        if (j3 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(u2, this.f40004b);
            if (j2 <= 0) {
                try {
                    future = this.f40004b.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.s(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f40004b.schedule(instantPeriodicTask, j2, timeUnit);
            }
            instantPeriodicTask.c(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u2);
        try {
            scheduledDirectPeriodicTask.a(this.f40004b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void h() {
        if (!this.f40005c) {
            this.f40005c = true;
            this.f40004b.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.f40005c;
    }
}
