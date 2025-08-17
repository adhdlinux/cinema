package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    private final Handler mHandler;

    public HandlerExecutorServiceImpl(Handler handler) {
        this.mHandler = handler;
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public boolean isHandlerThread() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void quit() {
        this.mHandler.getLooper().quit();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        ScheduledFutureImpl newTaskFor = newTaskFor(runnable, (Object) null);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j2));
        return newTaskFor;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public <T> ScheduledFutureImpl<T> newTaskFor(Runnable runnable, T t2) {
        return new ScheduledFutureImpl<>(this.mHandler, runnable, t2);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
        ScheduledFutureImpl<T> newTaskFor = newTaskFor(callable);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j2));
        return newTaskFor;
    }

    /* access modifiers changed from: protected */
    public <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> callable) {
        return new ScheduledFutureImpl<>(this.mHandler, callable);
    }

    public ScheduledFuture<?> submit(Runnable runnable) {
        return submit(runnable, (Object) null);
    }

    public <T> ScheduledFuture<T> submit(Runnable runnable, T t2) {
        runnable.getClass();
        ScheduledFutureImpl newTaskFor = newTaskFor(runnable, t2);
        execute(newTaskFor);
        return newTaskFor;
    }

    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        callable.getClass();
        ScheduledFutureImpl<T> newTaskFor = newTaskFor(callable);
        execute(newTaskFor);
        return newTaskFor;
    }
}
