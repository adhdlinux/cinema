package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    /* renamed from: a  reason: collision with root package name */
    static final long f38300a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class DisposeTask implements Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Runnable f38301b;

        /* renamed from: c  reason: collision with root package name */
        final Worker f38302c;

        /* renamed from: d  reason: collision with root package name */
        Thread f38303d;

        DisposeTask(Runnable runnable, Worker worker) {
            this.f38301b = runnable;
            this.f38302c = worker;
        }

        public void dispose() {
            if (this.f38303d == Thread.currentThread()) {
                Worker worker = this.f38302c;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).h();
                    return;
                }
            }
            this.f38302c.dispose();
        }

        public boolean isDisposed() {
            return this.f38302c.isDisposed();
        }

        public void run() {
            this.f38303d = Thread.currentThread();
            try {
                this.f38301b.run();
            } finally {
                dispose();
                this.f38303d = null;
            }
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Runnable f38304b;

        /* renamed from: c  reason: collision with root package name */
        final Worker f38305c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f38306d;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.f38304b = runnable;
            this.f38305c = worker;
        }

        public void dispose() {
            this.f38306d = true;
            this.f38305c.dispose();
        }

        public boolean isDisposed() {
            return this.f38306d;
        }

        public void run() {
            if (!this.f38306d) {
                try {
                    this.f38304b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38305c.dispose();
                    throw ExceptionHelper.d(th);
                }
            }
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final Runnable f38307b;

            /* renamed from: c  reason: collision with root package name */
            final SequentialDisposable f38308c;

            /* renamed from: d  reason: collision with root package name */
            final long f38309d;

            /* renamed from: e  reason: collision with root package name */
            long f38310e;

            /* renamed from: f  reason: collision with root package name */
            long f38311f;

            /* renamed from: g  reason: collision with root package name */
            long f38312g;

            PeriodicTask(long j2, Runnable runnable, long j3, SequentialDisposable sequentialDisposable, long j4) {
                this.f38307b = runnable;
                this.f38308c = sequentialDisposable;
                this.f38309d = j4;
                this.f38311f = j3;
                this.f38312g = j2;
            }

            public void run() {
                long j2;
                this.f38307b.run();
                if (!this.f38308c.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a2 = worker.a(timeUnit);
                    long j3 = Scheduler.f38300a;
                    long j4 = this.f38311f;
                    if (a2 + j3 >= j4) {
                        long j5 = this.f38309d;
                        if (a2 < j4 + j5 + j3) {
                            long j6 = this.f38312g;
                            long j7 = this.f38310e + 1;
                            this.f38310e = j7;
                            j2 = j6 + (j7 * j5);
                            this.f38311f = a2;
                            this.f38308c.a(Worker.this.c(this, j2 - a2, timeUnit));
                        }
                    }
                    long j8 = this.f38309d;
                    long j9 = a2 + j8;
                    long j10 = this.f38310e + 1;
                    this.f38310e = j10;
                    this.f38312g = j9 - (j8 * j10);
                    j2 = j9;
                    this.f38311f = a2;
                    this.f38308c.a(Worker.this.c(this, j2 - a2, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable b(Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable c(Runnable runnable, long j2, TimeUnit timeUnit);

        public Disposable d(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            long j4 = j2;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable u2 = RxJavaPlugins.u(runnable);
            long nanos = timeUnit2.toNanos(j3);
            long a2 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(a2 + timeUnit2.toNanos(j4), u2, a2, sequentialDisposable2, nanos);
            Disposable c2 = c(periodicTask, j4, timeUnit2);
            if (c2 == EmptyDisposable.INSTANCE) {
                return c2;
            }
            sequentialDisposable3.a(c2);
            return sequentialDisposable2;
        }
    }

    public abstract Worker a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable c(Runnable runnable) {
        return d(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Worker a2 = a();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.u(runnable), a2);
        a2.c(disposeTask, j2, timeUnit);
        return disposeTask;
    }

    public Disposable e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Worker a2 = a();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.u(runnable), a2);
        Disposable d2 = a2.d(periodicDirectTask, j2, j3, timeUnit);
        if (d2 == EmptyDisposable.INSTANCE) {
            return d2;
        }
        return periodicDirectTask;
    }
}
