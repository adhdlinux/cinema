package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t2);

    void onSubscribe(Disposable disposable);
}
