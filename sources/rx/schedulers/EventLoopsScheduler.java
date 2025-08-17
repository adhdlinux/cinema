package rx.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;

class EventLoopsScheduler extends Scheduler {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final RxThreadFactory f42115b = new RxThreadFactory("RxComputationThreadPool-");

    /* renamed from: c  reason: collision with root package name */
    static final int f42116c;

    /* renamed from: a  reason: collision with root package name */
    final FixedSchedulerPool f42117a = new FixedSchedulerPool();

    private static class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        private final CompositeSubscription f42118b = new CompositeSubscription();

        /* renamed from: c  reason: collision with root package name */
        private final PoolWorker f42119c;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f42119c = poolWorker;
        }

        public boolean isUnsubscribed() {
            return this.f42118b.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f42118b.unsubscribe();
        }
    }

    static final class FixedSchedulerPool {

        /* renamed from: a  reason: collision with root package name */
        final int f42120a;

        /* renamed from: b  reason: collision with root package name */
        final PoolWorker[] f42121b;

        /* renamed from: c  reason: collision with root package name */
        long f42122c;

        FixedSchedulerPool() {
            int i2 = EventLoopsScheduler.f42116c;
            this.f42120a = i2;
            this.f42121b = new PoolWorker[i2];
            for (int i3 = 0; i3 < this.f42120a; i3++) {
                this.f42121b[i3] = new PoolWorker(EventLoopsScheduler.f42115b);
            }
        }

        public PoolWorker a() {
            PoolWorker[] poolWorkerArr = this.f42121b;
            long j2 = this.f42122c;
            this.f42122c = 1 + j2;
            return poolWorkerArr[(int) (j2 % ((long) this.f42120a))];
        }
    }

    private static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f42116c = intValue;
    }

    EventLoopsScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f42117a.a());
    }
}
