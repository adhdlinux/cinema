package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class CallerThreadExecutor extends AbstractExecutorService {
    private static final CallerThreadExecutor sInstance = new CallerThreadExecutor();

    private CallerThreadExecutor() {
    }

    public static CallerThreadExecutor getInstance() {
        return sInstance;
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return true;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void shutdown() {
    }

    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
}
