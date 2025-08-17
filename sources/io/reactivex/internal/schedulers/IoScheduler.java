package io.reactivex.internal.schedulers;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f39983d;

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f39984e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f39985f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: g  reason: collision with root package name */
    private static final TimeUnit f39986g = TimeUnit.SECONDS;

    /* renamed from: h  reason: collision with root package name */
    static final ThreadWorker f39987h;

    /* renamed from: i  reason: collision with root package name */
    static final CachedWorkerPool f39988i;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f39989b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<CachedWorkerPool> f39990c;

    static final class CachedWorkerPool implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final long f39991b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<ThreadWorker> f39992c;

        /* renamed from: d  reason: collision with root package name */
        final CompositeDisposable f39993d;

        /* renamed from: e  reason: collision with root package name */
        private final ScheduledExecutorService f39994e;

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f39995f;

        /* renamed from: g  reason: collision with root package name */
        private final ThreadFactory f39996g;

        CachedWorkerPool(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j3;
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            if (timeUnit != null) {
                j3 = timeUnit.toNanos(j2);
            } else {
                j3 = 0;
            }
            long j4 = j3;
            this.f39991b = j4;
            this.f39992c = new ConcurrentLinkedQueue<>();
            this.f39993d = new CompositeDisposable();
            this.f39996g = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f39984e);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j4, j4, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f39994e = scheduledExecutorService;
            this.f39995f = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f39992c.isEmpty()) {
                long c2 = c();
                Iterator<ThreadWorker> it2 = this.f39992c.iterator();
                while (it2.hasNext()) {
                    ThreadWorker next = it2.next();
                    if (next.i() > c2) {
                        return;
                    }
                    if (this.f39992c.remove(next)) {
                        this.f39993d.a(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ThreadWorker b() {
            if (this.f39993d.isDisposed()) {
                return IoScheduler.f39987h;
            }
            while (!this.f39992c.isEmpty()) {
                ThreadWorker poll = this.f39992c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.f39996g);
            this.f39993d.b(threadWorker);
            return threadWorker;
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void d(ThreadWorker threadWorker) {
            threadWorker.j(c() + this.f39991b);
            this.f39992c.offer(threadWorker);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f39993d.dispose();
            Future<?> future = this.f39995f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f39994e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a();
        }
    }

    static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        private final CompositeDisposable f39997b;

        /* renamed from: c  reason: collision with root package name */
        private final CachedWorkerPool f39998c;

        /* renamed from: d  reason: collision with root package name */
        private final ThreadWorker f39999d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f40000e = new AtomicBoolean();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.f39998c = cachedWorkerPool;
            this.f39997b = new CompositeDisposable();
            this.f39999d = cachedWorkerPool.b();
        }

        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f39997b.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f39999d.e(runnable, j2, timeUnit, this.f39997b);
        }

        public void dispose() {
            if (this.f40000e.compareAndSet(false, true)) {
                this.f39997b.dispose();
                this.f39998c.d(this.f39999d);
            }
        }

        public boolean isDisposed() {
            return this.f40000e.get();
        }
    }

    static final class ThreadWorker extends NewThreadWorker {

        /* renamed from: d  reason: collision with root package name */
        private long f40001d = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long i() {
            return this.f40001d;
        }

        public void j(long j2) {
            this.f40001d = j2;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f39987h = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f39983d = rxThreadFactory;
        f39984e = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, rxThreadFactory);
        f39988i = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(f39983d);
    }

    public Scheduler.Worker a() {
        return new EventLoopWorker(this.f39990c.get());
    }

    public void f() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f39985f, f39986g, this.f39989b);
        if (!f.a(this.f39990c, f39988i, cachedWorkerPool)) {
            cachedWorkerPool.e();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f39989b = threadFactory;
        this.f39990c = new AtomicReference<>(f39988i);
        f();
    }
}
