package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    private static final RxThreadFactory f40002c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f40003b;

    public NewThreadScheduler() {
        this(f40002c);
    }

    public Scheduler.Worker a() {
        return new NewThreadWorker(this.f40003b);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f40003b = threadFactory;
    }
}
