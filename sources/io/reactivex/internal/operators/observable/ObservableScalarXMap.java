package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39457b;

        /* renamed from: c  reason: collision with root package name */
        final T f39458c;

        public ScalarDisposable(Observer<? super T> observer, T t2) {
            this.f39457b = observer;
            this.f39458c = t2;
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isDisposed() {
            return get() == 3;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f39458c;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f39457b.onNext(this.f39458c);
                if (get() == 2) {
                    lazySet(3);
                    this.f39457b.onComplete();
                }
            }
        }
    }

    static final class ScalarXMapObservable<T, R> extends Observable<R> {

        /* renamed from: b  reason: collision with root package name */
        final T f39459b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f39460c;

        ScalarXMapObservable(T t2, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f39459b = t2;
            this.f39460c = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39460c.apply(this.f39459b), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.c(observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptyDisposable.e(th, observer);
                    }
                } else {
                    observableSource.subscribe(observer);
                }
            } catch (Throwable th2) {
                EmptyDisposable.e(th2, observer);
            }
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> a(T t2, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.n(new ScalarXMapObservable(t2, function));
    }

    public static <T, R> boolean b(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) observableSource).call();
            if (call == null) {
                EmptyDisposable.c(observer);
                return true;
            }
            try {
                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(function.apply(call), "The mapper returned a null ObservableSource");
                if (observableSource2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) observableSource2).call();
                        if (call2 == null) {
                            EmptyDisposable.c(observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call2);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptyDisposable.e(th, observer);
                        return true;
                    }
                } else {
                    observableSource2.subscribe(observer);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptyDisposable.e(th2, observer);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptyDisposable.e(th3, observer);
            return true;
        }
    }
}
