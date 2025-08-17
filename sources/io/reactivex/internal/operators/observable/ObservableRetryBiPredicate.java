package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final BiPredicate<? super Integer, ? super Throwable> f39414c;

    static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39415b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39416c;

        /* renamed from: d  reason: collision with root package name */
        final ObservableSource<? extends T> f39417d;

        /* renamed from: e  reason: collision with root package name */
        final BiPredicate<? super Integer, ? super Throwable> f39418e;

        /* renamed from: f  reason: collision with root package name */
        int f39419f;

        RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f39415b = observer;
            this.f39416c = sequentialDisposable;
            this.f39417d = observableSource;
            this.f39418e = biPredicate;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f39416c.isDisposed()) {
                    this.f39417d.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f39415b.onComplete();
        }

        public void onError(Throwable th) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f39418e;
                int i2 = this.f39419f + 1;
                this.f39419f = i2;
                if (!biPredicate.test(Integer.valueOf(i2), th)) {
                    this.f39415b.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f39415b.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t2) {
            this.f39415b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39416c.a(disposable);
        }
    }

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f39414c = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f39414c, sequentialDisposable, this.f38612b).a();
    }
}
