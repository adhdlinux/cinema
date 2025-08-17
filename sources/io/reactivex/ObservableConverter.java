package io.reactivex;

public interface ObservableConverter<T, R> {
    R a(Observable<T> observable);
}
