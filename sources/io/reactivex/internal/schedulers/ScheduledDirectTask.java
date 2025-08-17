package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: b */
    public Void call() throws Exception {
        this.f39941c = Thread.currentThread();
        try {
            this.f39940b.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f39938d);
            this.f39941c = null;
        }
    }
}
