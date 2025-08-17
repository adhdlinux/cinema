package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleSettableFuture<T> implements Future<T> {
    private Exception mException;
    private final CountDownLatch mReadyLatch = new CountDownLatch(1);
    private T mResult;

    private void checkNotSet() {
        if (this.mReadyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }

    public boolean cancel(boolean z2) {
        throw new UnsupportedOperationException();
    }

    public T get() throws InterruptedException, ExecutionException {
        this.mReadyLatch.await();
        if (this.mException == null) {
            return this.mResult;
        }
        throw new ExecutionException(this.mException);
    }

    public T getOrThrow() {
        try {
            return get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return this.mReadyLatch.getCount() == 0;
    }

    public void set(T t2) {
        checkNotSet();
        this.mResult = t2;
        this.mReadyLatch.countDown();
    }

    public void setException(Exception exc) {
        checkNotSet();
        this.mException = exc;
        this.mReadyLatch.countDown();
    }

    public T getOrThrow(long j2, TimeUnit timeUnit) {
        try {
            return get(j2, timeUnit);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!this.mReadyLatch.await(j2, timeUnit)) {
            throw new TimeoutException("Timed out waiting for result");
        } else if (this.mException == null) {
            return this.mResult;
        } else {
            throw new ExecutionException(this.mException);
        }
    }
}
