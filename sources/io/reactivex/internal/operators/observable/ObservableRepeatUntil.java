package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {

    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39365b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39366c;

        /* renamed from: d  reason: collision with root package name */
        final ObservableSource<? extends T> f39367d;

        RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f39365b = observer;
            this.f39366c = sequentialDisposable;
            this.f39367d = observableSource;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.f39367d.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void onComplete() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39365b.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.f39365b.onError(th);
        }

        public void onNext(T t2) {
            this.f39365b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39366c.a(disposable);
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, (BooleanSupplier) null, sequentialDisposable, this.f38612b).a();
    }
}
