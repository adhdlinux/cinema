package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ExperimentalThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    private final Executor mExecutor;

    public ExperimentalThreadHandoffProducerQueueImpl(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    public void addToQueueOrExecute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    public boolean isQueueing() {
        return false;
    }

    public void remove(Runnable runnable) {
    }

    public void startQueueing() {
        throw new UnsupportedOperationException();
    }

    public void stopQueuing() {
        throw new UnsupportedOperationException();
    }
}
