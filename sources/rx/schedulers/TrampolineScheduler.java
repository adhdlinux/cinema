package rx.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.subscriptions.BooleanSubscription;

public final class TrampolineScheduler extends Scheduler {

    /* renamed from: a  reason: collision with root package name */
    private static final TrampolineScheduler f42149a = new TrampolineScheduler();

    private static class InnerCurrentThreadScheduler extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater<InnerCurrentThreadScheduler> f42150f = AtomicIntegerFieldUpdater.newUpdater(InnerCurrentThreadScheduler.class, "b");

        /* renamed from: b  reason: collision with root package name */
        volatile int f42151b;

        /* renamed from: c  reason: collision with root package name */
        private final PriorityBlockingQueue<Object> f42152c;

        /* renamed from: d  reason: collision with root package name */
        private final BooleanSubscription f42153d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicInteger f42154e;

        private InnerCurrentThreadScheduler() {
            this.f42152c = new PriorityBlockingQueue<>();
            this.f42153d = new BooleanSubscription();
            this.f42154e = new AtomicInteger();
        }

        public boolean isUnsubscribed() {
            return this.f42153d.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f42153d.unsubscribe();
        }
    }

    TrampolineScheduler() {
    }

    static TrampolineScheduler a() {
        return f42149a;
    }

    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }
}
