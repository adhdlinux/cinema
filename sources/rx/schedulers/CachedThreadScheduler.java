package rx.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;

final class CachedThreadScheduler extends Scheduler {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final RxThreadFactory f42103a = new RxThreadFactory("RxCachedThreadScheduler-");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final RxThreadFactory f42104b = new RxThreadFactory("RxCachedWorkerPoolEvictor-");

    private static final class CachedWorkerPool {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static CachedWorkerPool f42105d = new CachedWorkerPool(60, TimeUnit.SECONDS);

        /* renamed from: a  reason: collision with root package name */
        private final long f42106a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentLinkedQueue<ThreadWorker> f42107b = new ConcurrentLinkedQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final ScheduledExecutorService f42108c;

        CachedWorkerPool(long j2, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j2);
            this.f42106a = nanos;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, CachedThreadScheduler.f42104b);
            this.f42108c = newScheduledThreadPool;
            newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    CachedWorkerPool.this.b();
                }
            }, nanos, nanos, TimeUnit.NANOSECONDS);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.f42107b.isEmpty()) {
                long d2 = d();
                Iterator<ThreadWorker> it2 = this.f42107b.iterator();
                while (it2.hasNext()) {
                    ThreadWorker next = it2.next();
                    if (next.e() > d2) {
                        return;
                    }
                    if (this.f42107b.remove(next)) {
                        next.unsubscribe();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ThreadWorker c() {
            while (!this.f42107b.isEmpty()) {
                ThreadWorker poll = this.f42107b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            return new ThreadWorker(CachedThreadScheduler.f42103a);
        }

        /* access modifiers changed from: package-private */
        public long d() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void e(ThreadWorker threadWorker) {
            threadWorker.f(d() + this.f42106a);
            this.f42107b.offer(threadWorker);
        }
    }

    private static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: e  reason: collision with root package name */
        static final AtomicIntegerFieldUpdater<EventLoopWorker> f42110e = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "d");

        /* renamed from: b  reason: collision with root package name */
        private final CompositeSubscription f42111b = new CompositeSubscription();

        /* renamed from: c  reason: collision with root package name */
        private final ThreadWorker f42112c;

        /* renamed from: d  reason: collision with root package name */
        volatile int f42113d;

        EventLoopWorker(ThreadWorker threadWorker) {
            this.f42112c = threadWorker;
        }

        public boolean isUnsubscribed() {
            return this.f42111b.isUnsubscribed();
        }

        public void unsubscribe() {
            if (f42110e.compareAndSet(this, 0, 1)) {
                CachedWorkerPool.f42105d.e(this.f42112c);
            }
            this.f42111b.unsubscribe();
        }
    }

    private static final class ThreadWorker extends NewThreadWorker {

        /* renamed from: i  reason: collision with root package name */
        private long f42114i = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long e() {
            return this.f42114i;
        }

        public void f(long j2) {
            this.f42114i = j2;
        }
    }

    CachedThreadScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(CachedWorkerPool.f42105d.c());
    }
}
