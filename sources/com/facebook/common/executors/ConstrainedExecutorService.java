package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ConstrainedExecutorService extends AbstractExecutorService {
    /* access modifiers changed from: private */
    public static final Class<?> TAG = ConstrainedExecutorService.class;
    private final Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final AtomicInteger mMaxQueueSize;
    /* access modifiers changed from: private */
    public final String mName;
    /* access modifiers changed from: private */
    public final AtomicInteger mPendingWorkers;
    private final Worker mTaskRunner;
    /* access modifiers changed from: private */
    public final BlockingQueue<Runnable> mWorkQueue;

    private class Worker implements Runnable {
        private Worker() {
        }

        public void run() {
            AtomicInteger access$400;
            boolean isEmpty;
            try {
                Runnable runnable = (Runnable) ConstrainedExecutorService.this.mWorkQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    FLog.v((Class<?>) ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", (Object) ConstrainedExecutorService.this.mName);
                }
                if (isEmpty) {
                    FLog.v((Class<?>) ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", (Object) ConstrainedExecutorService.this.mName, (Object) Integer.valueOf(access$400.decrementAndGet()));
                }
            } finally {
                int decrementAndGet = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (!ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                } else {
                    FLog.v((Class<?>) ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", (Object) ConstrainedExecutorService.this.mName, (Object) Integer.valueOf(decrementAndGet));
                }
            }
        }
    }

    public ConstrainedExecutorService(String str, int i2, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i2 > 0) {
            this.mName = str;
            this.mExecutor = executor;
            this.mMaxConcurrency = i2;
            this.mWorkQueue = blockingQueue;
            this.mTaskRunner = new Worker();
            this.mPendingWorkers = new AtomicInteger(0);
            this.mMaxQueueSize = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i2, int i3, Executor executor) {
        return new ConstrainedExecutorService(str, i2, executor, new LinkedBlockingQueue(i3));
    }

    /* access modifiers changed from: private */
    public void startWorkerIfNeeded() {
        int i2 = this.mPendingWorkers.get();
        while (i2 < this.mMaxConcurrency) {
            int i3 = i2 + 1;
            if (this.mPendingWorkers.compareAndSet(i2, i3)) {
                FLog.v(TAG, "%s: starting worker %d of %d", (Object) this.mName, (Object) Integer.valueOf(i3), (Object) Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            }
            FLog.v(TAG, "%s: race in startWorkerIfNeeded; retrying", (Object) this.mName);
            i2 = this.mPendingWorkers.get();
        }
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.mWorkQueue.offer(runnable)) {
            int size = this.mWorkQueue.size();
            int i2 = this.mMaxQueueSize.get();
            if (size > i2 && this.mMaxQueueSize.compareAndSet(i2, size)) {
                FLog.v(TAG, "%s: max pending work in queue = %d", (Object) this.mName, (Object) Integer.valueOf(size));
            }
            startWorkerIfNeeded();
        } else {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
        }
    }

    public boolean isIdle() {
        return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
