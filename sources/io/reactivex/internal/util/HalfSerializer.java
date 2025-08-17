package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = atomicThrowable.b();
            if (b2 != null) {
                observer.onError(b2);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void b(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = atomicThrowable.b();
            if (b2 != null) {
                subscriber.onError(b2);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void c(Observer<?> observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th)) {
            RxJavaPlugins.s(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            observer.onError(atomicThrowable.b());
        }
    }

    public static void d(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th)) {
            RxJavaPlugins.s(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.b());
        }
    }

    public static <T> void e(Observer<? super T> observer, T t2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t2);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = atomicThrowable.b();
                if (b2 != null) {
                    observer.onError(b2);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    public static <T> void f(Subscriber<? super T> subscriber, T t2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t2);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = atomicThrowable.b();
                if (b2 != null) {
                    subscriber.onError(b2);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }
}
