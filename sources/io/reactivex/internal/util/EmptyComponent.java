package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public static <T> Observer<T> b() {
        return INSTANCE;
    }

    public void a(Subscription subscription) {
        subscription.cancel();
    }

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onError(Throwable th) {
        RxJavaPlugins.s(th);
    }

    public void onNext(Object obj) {
    }

    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    public void onSuccess(Object obj) {
    }

    public void request(long j2) {
    }
}
