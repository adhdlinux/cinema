package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {

    /* renamed from: b  reason: collision with root package name */
    private static final TrampolineScheduler f40027b = new TrampolineScheduler();

    static final class SleepingRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f40028b;

        /* renamed from: c  reason: collision with root package name */
        private final TrampolineWorker f40029c;

        /* renamed from: d  reason: collision with root package name */
        private final long f40030d;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j2) {
            this.f40028b = runnable;
            this.f40029c = trampolineWorker;
            this.f40030d = j2;
        }

        public void run() {
            if (!this.f40029c.f40038e) {
                long a2 = this.f40029c.a(TimeUnit.MILLISECONDS);
                long j2 = this.f40030d;
                if (j2 > a2) {
                    try {
                        Thread.sleep(j2 - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.s(e2);
                        return;
                    }
                }
                if (!this.f40029c.f40038e) {
                    this.f40028b.run();
                }
            }
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: b  reason: collision with root package name */
        final Runnable f40031b;

        /* renamed from: c  reason: collision with root package name */
        final long f40032c;

        /* renamed from: d  reason: collision with root package name */
        final int f40033d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f40034e;

        TimedRunnable(Runnable runnable, Long l2, int i2) {
            this.f40031b = runnable;
            this.f40032c = l2.longValue();
            this.f40033d = i2;
        }

        /* renamed from: a */
        public int compareTo(TimedRunnable timedRunnable) {
            int b2 = ObjectHelper.b(this.f40032c, timedRunnable.f40032c);
            if (b2 == 0) {
                return ObjectHelper.a(this.f40033d, timedRunnable.f40033d);
            }
            return b2;
        }
    }

    static final class TrampolineWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<TimedRunnable> f40035b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f40036c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f40037d = new AtomicInteger();

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f40038e;

        final class AppendToQueueTask implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final TimedRunnable f40039b;

            AppendToQueueTask(TimedRunnable timedRunnable) {
                this.f40039b = timedRunnable;
            }

            public void run() {
                this.f40039b.f40034e = true;
                TrampolineWorker.this.f40035b.remove(this.f40039b);
            }
        }

        TrampolineWorker() {
        }

        public Disposable b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return e(new SleepingRunnable(runnable, this, a2), a2);
        }

        public void dispose() {
            this.f40038e = true;
        }

        /* access modifiers changed from: package-private */
        public Disposable e(Runnable runnable, long j2) {
            if (this.f40038e) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j2), this.f40037d.incrementAndGet());
            this.f40035b.add(timedRunnable);
            if (this.f40036c.getAndIncrement() != 0) {
                return Disposables.d(new AppendToQueueTask(timedRunnable));
            }
            int i2 = 1;
            while (!this.f40038e) {
                TimedRunnable poll = this.f40035b.poll();
                if (poll == null) {
                    i2 = this.f40036c.addAndGet(-i2);
                    if (i2 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f40034e) {
                    poll.f40031b.run();
                }
            }
            this.f40035b.clear();
            return EmptyDisposable.INSTANCE;
        }

        public boolean isDisposed() {
            return this.f40038e;
        }
    }

    TrampolineScheduler() {
    }

    public static TrampolineScheduler f() {
        return f40027b;
    }

    public Scheduler.Worker a() {
        return new TrampolineWorker();
    }

    public Disposable c(Runnable runnable) {
        RxJavaPlugins.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            RxJavaPlugins.u(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.s(e2);
        }
        return EmptyDisposable.INSTANCE;
    }
}
