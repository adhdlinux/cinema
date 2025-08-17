package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f39467c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<R> f39468d;

    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39469b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<R, ? super T, R> f39470c;

        /* renamed from: d  reason: collision with root package name */
        R f39471d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f39472e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39473f;

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r2) {
            this.f39469b = observer;
            this.f39470c = biFunction;
            this.f39471d = r2;
        }

        public void dispose() {
            this.f39472e.dispose();
        }

        public boolean isDisposed() {
            return this.f39472e.isDisposed();
        }

        public void onComplete() {
            if (!this.f39473f) {
                this.f39473f = true;
                this.f39469b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f39473f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39473f = true;
            this.f39469b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39473f) {
                try {
                    R e2 = ObjectHelper.e(this.f39470c.apply(this.f39471d, t2), "The accumulator returned a null value");
                    this.f39471d = e2;
                    this.f39469b.onNext(e2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39472e.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39472e, disposable)) {
                this.f39472e = disposable;
                this.f39469b.onSubscribe(this);
                this.f39469b.onNext(this.f39471d);
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f39467c = biFunction;
        this.f39468d = callable;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            this.f38612b.subscribe(new ScanSeedObserver(observer, this.f39467c, ObjectHelper.e(this.f39468d.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }
}
