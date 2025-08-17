package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.QueueDisposable;

public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    public static void a(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onComplete();
    }

    public static void c(Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onComplete();
    }

    public static void d(Throwable th, CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onError(th);
    }

    public static void e(Throwable th, Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onError(th);
    }

    public static void f(Throwable th, SingleObserver<?> singleObserver) {
        singleObserver.onSubscribe(INSTANCE);
        singleObserver.onError(th);
    }

    public int b(int i2) {
        return i2 & 2;
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }
}
