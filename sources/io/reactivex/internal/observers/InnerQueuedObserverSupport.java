package io.reactivex.internal.observers;

public interface InnerQueuedObserverSupport<T> {
    void a();

    void b(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void c(InnerQueuedObserver<T> innerQueuedObserver);

    void d(InnerQueuedObserver<T> innerQueuedObserver, T t2);
}
