package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f39709c;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f39710b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39711c;

        /* renamed from: d  reason: collision with root package name */
        U f39712d;

        ToListObserver(Observer<? super U> observer, U u2) {
            this.f39710b = observer;
            this.f39712d = u2;
        }

        public void dispose() {
            this.f39711c.dispose();
        }

        public boolean isDisposed() {
            return this.f39711c.isDisposed();
        }

        public void onComplete() {
            U u2 = this.f39712d;
            this.f39712d = null;
            this.f39710b.onNext(u2);
            this.f39710b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39712d = null;
            this.f39710b.onError(th);
        }

        public void onNext(T t2) {
            this.f39712d.add(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39711c, disposable)) {
                this.f39711c = disposable;
                this.f39710b.onSubscribe(this);
            }
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f39709c = Functions.e(i2);
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f38612b.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.e(this.f39709c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.f39709c = callable;
    }
}
