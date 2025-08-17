package rx.schedulers;

import rx.Scheduler;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;

public final class NewThreadScheduler extends Scheduler {

    /* renamed from: a  reason: collision with root package name */
    private static final RxThreadFactory f42135a = new RxThreadFactory("RxNewThreadScheduler-");

    /* renamed from: b  reason: collision with root package name */
    private static final NewThreadScheduler f42136b = new NewThreadScheduler();

    private NewThreadScheduler() {
    }

    static NewThreadScheduler a() {
        return f42136b;
    }

    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(f42135a);
    }
}
