package com.startapp;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class p2 implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f35599a;

    public p2(ScheduledExecutorService scheduledExecutorService) {
        this.f35599a = scheduledExecutorService;
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f35599a.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f35599a.execute(new o2(runnable));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f35599a.invokeAll(m2.a(collection));
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.f35599a.invokeAny(m2.a(collection));
    }

    public boolean isShutdown() {
        return this.f35599a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f35599a.isTerminated();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f35599a.schedule(new o2(runnable), j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f35599a.scheduleAtFixedRate(new o2(runnable), j2, j3, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f35599a.scheduleWithFixedDelay(new o2(runnable), j2, j3, timeUnit);
    }

    public void shutdown() {
        this.f35599a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f35599a.shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f35599a.submit(new m2(callable));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f35599a.invokeAll(m2.a(collection), j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f35599a.invokeAny(m2.a(collection), j2, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
        return this.f35599a.schedule(new m2(callable), j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.f35599a.submit(new o2(runnable), t2);
    }

    public Future<?> submit(Runnable runnable) {
        return this.f35599a.submit(new o2(runnable));
    }
}
