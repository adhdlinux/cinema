package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
    public DefaultSerialExecutorService(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
