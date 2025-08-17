package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.f39941c = Thread.currentThread();
        try {
            this.f39940b.run();
            this.f39941c = null;
        } catch (Throwable th) {
            this.f39941c = null;
            lazySet(AbstractDirectTask.f39938d);
            RxJavaPlugins.s(th);
        }
    }
}
