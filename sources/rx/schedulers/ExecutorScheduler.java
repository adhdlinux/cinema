package rx.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

final class ExecutorScheduler extends Scheduler {

    /* renamed from: a  reason: collision with root package name */
    final Executor f42123a;

    static final class ExecutorAction implements Runnable, Subscription {

        /* renamed from: e  reason: collision with root package name */
        static final AtomicIntegerFieldUpdater<ExecutorAction> f42124e = AtomicIntegerFieldUpdater.newUpdater(ExecutorAction.class, "d");

        /* renamed from: b  reason: collision with root package name */
        final Action0 f42125b;

        /* renamed from: c  reason: collision with root package name */
        final CompositeSubscription f42126c;

        /* renamed from: d  reason: collision with root package name */
        volatile int f42127d;

        public boolean isUnsubscribed() {
            return this.f42127d != 0;
        }

        public void run() {
            if (!isUnsubscribed()) {
                try {
                    this.f42125b.call();
                } catch (Throwable th) {
                    unsubscribe();
                    throw th;
                }
                unsubscribe();
            }
        }

        public void unsubscribe() {
            if (f42124e.compareAndSet(this, 0, 1)) {
                this.f42126c.a(this);
            }
        }
    }

    static final class ExecutorSchedulerWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Executor f42128b;

        /* renamed from: c  reason: collision with root package name */
        final CompositeSubscription f42129c = new CompositeSubscription();

        /* renamed from: d  reason: collision with root package name */
        final ConcurrentLinkedQueue<ExecutorAction> f42130d = new ConcurrentLinkedQueue<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f42131e = new AtomicInteger();

        public ExecutorSchedulerWorker(Executor executor) {
            this.f42128b = executor;
        }

        public boolean isUnsubscribed() {
            return this.f42129c.isUnsubscribed();
        }

        public void run() {
            do {
                this.f42130d.poll().run();
            } while (this.f42131e.decrementAndGet() > 0);
        }

        public void unsubscribe() {
            this.f42129c.unsubscribe();
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.f42123a = executor;
    }

    public Scheduler.Worker createWorker() {
        return new ExecutorSchedulerWorker(this.f42123a);
    }
}
