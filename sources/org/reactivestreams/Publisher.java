package org.reactivestreams;

public interface Publisher<T> {
    void a(Subscriber<? super T> subscriber);
}
