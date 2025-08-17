package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    private final Executor mExecutor;
    private boolean mQueueing = false;
    private final Deque<Runnable> mRunnableList;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mRunnableList = new ArrayDeque();
    }

    private void execInQueue() {
        while (!this.mRunnableList.isEmpty()) {
            this.mExecutor.execute(this.mRunnableList.pop());
        }
        this.mRunnableList.clear();
    }

    public synchronized void addToQueueOrExecute(Runnable runnable) {
        if (this.mQueueing) {
            this.mRunnableList.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized boolean isQueueing() {
        return this.mQueueing;
    }

    public synchronized void remove(Runnable runnable) {
        this.mRunnableList.remove(runnable);
    }

    public synchronized void startQueueing() {
        this.mQueueing = true;
    }

    public synchronized void stopQueuing() {
        this.mQueueing = false;
        execInQueue();
    }
}
