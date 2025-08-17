package rx.schedulers;

import rx.Scheduler;
import rx.subscriptions.BooleanSubscription;

public final class ImmediateScheduler extends Scheduler {

    /* renamed from: a  reason: collision with root package name */
    private static final ImmediateScheduler f42132a = new ImmediateScheduler();

    private class InnerImmediateScheduler extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        final BooleanSubscription f42133b;

        private InnerImmediateScheduler() {
            this.f42133b = new BooleanSubscription();
        }

        public boolean isUnsubscribed() {
            return this.f42133b.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f42133b.unsubscribe();
        }
    }

    ImmediateScheduler() {
    }

    static ImmediateScheduler a() {
        return f42132a;
    }

    public Scheduler.Worker createWorker() {
        return new InnerImmediateScheduler();
    }
}
