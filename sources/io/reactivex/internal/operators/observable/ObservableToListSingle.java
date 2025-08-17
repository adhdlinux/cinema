package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39713b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f39714c;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super U> f39715b;

        /* renamed from: c  reason: collision with root package name */
        U f39716c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39717d;

        ToListObserver(SingleObserver<? super U> singleObserver, U u2) {
            this.f39715b = singleObserver;
            this.f39716c = u2;
        }

        public void dispose() {
            this.f39717d.dispose();
        }

        public boolean isDisposed() {
            return this.f39717d.isDisposed();
        }

        public void onComplete() {
            U u2 = this.f39716c;
            this.f39716c = null;
            this.f39715b.onSuccess(u2);
        }

        public void onError(Throwable th) {
            this.f39716c = null;
            this.f39715b.onError(th);
        }

        public void onNext(T t2) {
            this.f39716c.add(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39717d, disposable)) {
                this.f39717d = disposable;
                this.f39715b.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i2) {
        this.f39713b = observableSource;
        this.f39714c = Functions.e(i2);
    }

    public Observable<U> b() {
        return RxJavaPlugins.n(new ObservableToList(this.f39713b, this.f39714c));
    }

    public void j(SingleObserver<? super U> singleObserver) {
        try {
            this.f39713b.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.e(this.f39714c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, singleObserver);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f39713b = observableSource;
        this.f39714c = callable;
    }
}
