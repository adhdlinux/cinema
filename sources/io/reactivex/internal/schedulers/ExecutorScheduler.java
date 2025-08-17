package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    static final Scheduler f39957d = Schedulers.d();

    /* renamed from: b  reason: collision with root package name */
    final boolean f39958b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f39959c;

    final class DelayedDispose implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final DelayedRunnable f39960b;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f39960b = delayedRunnable;
        }

        public void run() {
            DelayedRunnable delayedRunnable = this.f39960b;
            delayedRunnable.f39963c.a(ExecutorScheduler.this.c(delayedRunnable));
        }
    }

    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SequentialDisposable f39962b = new SequentialDisposable();

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39963c = new SequentialDisposable();

        DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public void dispose() {
            if (getAndSet((Object) null) != null) {
                this.f39962b.dispose();
                this.f39963c.dispose();
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    SequentialDisposable sequentialDisposable = this.f39962b;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f39963c.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet((Object) null);
                    this.f39962b.lazySet(DisposableHelper.DISPOSED);
                    this.f39963c.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final boolean f39964b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f39965c;

        /* renamed from: d  reason: collision with root package name */
        final MpscLinkedQueue<Runnable> f39966d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39967e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f39968f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final CompositeDisposable f39969g = new CompositeDisposable();

        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {

            /* renamed from: b  reason: collision with root package name */
            final Runnable f39970b;

            BooleanRunnable(Runnable runnable) {
                this.f39970b = runnable;
            }

            public void dispose() {
                lazySet(true);
            }

            public boolean isDisposed() {
                return get();
            }

            public void run() {
                if (!get()) {
                    try {
                        this.f39970b.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {

            /* renamed from: b  reason: collision with root package name */
            final Runnable f39971b;

            /* renamed from: c  reason: collision with root package name */
            final DisposableContainer f39972c;

            /* renamed from: d  reason: collision with root package name */
            volatile Thread f39973d;

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.f39971b = runnable;
                this.f39972c = disposableContainer;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableContainer disposableContainer = this.f39972c;
                if (disposableContainer != null) {
                    disposableContainer.c(this);
                }
            }

            public void dispose() {
                while (true) {
                    int i2 = get();
                    if (i2 < 2) {
                        if (i2 == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.f39973d;
                            if (thread != null) {
                                thread.interrupt();
                                this.f39973d = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public boolean isDisposed() {
                return get() >= 2;
            }

            public void run() {
                if (get() == 0) {
                    this.f39973d = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f39971b.run();
                            this.f39973d = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.f39973d = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    } else {
                        this.f39973d = null;
                    }
                }
            }
        }

        final class SequentialDispose implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final SequentialDisposable f39974b;

            /* renamed from: c  reason: collision with root package name */
            private final Runnable f39975c;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f39974b = sequentialDisposable;
                this.f39975c = runnable;
            }

            public void run() {
                this.f39974b.a(ExecutorWorker.this.b(this.f39975c));
            }
        }

        public ExecutorWorker(Executor executor, boolean z2) {
            this.f39965c = executor;
            this.f39966d = new MpscLinkedQueue<>();
            this.f39964b = z2;
        }

        public Disposable b(Runnable runnable) {
            Disposable disposable;
            if (this.f39967e) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable u2 = RxJavaPlugins.u(runnable);
            if (this.f39964b) {
                disposable = new InterruptibleRunnable(u2, this.f39969g);
                this.f39969g.b(disposable);
            } else {
                disposable = new BooleanRunnable(u2);
            }
            this.f39966d.offer(disposable);
            if (this.f39968f.getAndIncrement() == 0) {
                try {
                    this.f39965c.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f39967e = true;
                    this.f39966d.clear();
                    RxJavaPlugins.s(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return b(runnable);
            }
            if (this.f39967e) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.u(runnable)), this.f39969g);
            this.f39969g.b(scheduledRunnable);
            Executor executor = this.f39965c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule(scheduledRunnable, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f39967e = true;
                    RxJavaPlugins.s(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new DisposeOnCancel(ExecutorScheduler.f39957d.d(scheduledRunnable, j2, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        public void dispose() {
            if (!this.f39967e) {
                this.f39967e = true;
                this.f39969g.dispose();
                if (this.f39968f.getAndIncrement() == 0) {
                    this.f39966d.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39967e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f39968f.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f39967e == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.f39966d
                r1 = 1
            L_0x0003:
                boolean r2 = r3.f39967e
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.f39967e
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f39968f
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.f39967e
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }
    }

    public ExecutorScheduler(Executor executor, boolean z2) {
        this.f39959c = executor;
        this.f39958b = z2;
    }

    public Scheduler.Worker a() {
        return new ExecutorWorker(this.f39959c, this.f39958b);
    }

    public Disposable c(Runnable runnable) {
        Runnable u2 = RxJavaPlugins.u(runnable);
        try {
            if (this.f39959c instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u2);
                scheduledDirectTask.a(((ExecutorService) this.f39959c).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f39958b) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(u2, (DisposableContainer) null);
                this.f39959c.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(u2);
                this.f39959c.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.s(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable u2 = RxJavaPlugins.u(runnable);
        if (this.f39959c instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u2);
                scheduledDirectTask.a(((ScheduledExecutorService) this.f39959c).schedule(scheduledDirectTask, j2, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.s(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(u2);
            delayedRunnable.f39962b.a(f39957d.d(new DelayedDispose(delayedRunnable), j2, timeUnit));
            return delayedRunnable;
        }
    }

    public Disposable e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (!(this.f39959c instanceof ScheduledExecutorService)) {
            return super.e(runnable, j2, j3, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.u(runnable));
            scheduledDirectPeriodicTask.a(((ScheduledExecutorService) this.f39959c).scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.s(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
