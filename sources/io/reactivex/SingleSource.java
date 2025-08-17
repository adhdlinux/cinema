package io.reactivex;

public interface SingleSource<T> {
    void a(SingleObserver<? super T> singleObserver);
}
