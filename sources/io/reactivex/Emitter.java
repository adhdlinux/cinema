package io.reactivex;

public interface Emitter<T> {
    void onComplete();

    void onNext(T t2);
}
