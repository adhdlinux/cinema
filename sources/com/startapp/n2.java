package com.startapp;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class n2 implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f34949a;

    public n2(ExecutorService executorService) {
        this.f34949a = executorService;
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f34949a.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f34949a.execute(new o2(runnable));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f34949a.invokeAll(m2.a(collection));
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.f34949a.invokeAny(m2.a(collection));
    }

    public boolean isShutdown() {
        return this.f34949a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f34949a.isTerminated();
    }

    public void shutdown() {
        this.f34949a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f34949a.shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f34949a.submit(new m2(callable));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f34949a.invokeAll(m2.a(collection), j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f34949a.invokeAny(m2.a(collection), j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.f34949a.submit(new o2(runnable), t2);
    }

    public Future<?> submit(Runnable runnable) {
        return this.f34949a.submit(new o2(runnable));
    }
}
