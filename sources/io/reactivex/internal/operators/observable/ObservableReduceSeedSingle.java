package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39335b;

    /* renamed from: c  reason: collision with root package name */
    final R f39336c;

    /* renamed from: d  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f39337d;

    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super R> f39338b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<R, ? super T, R> f39339c;

        /* renamed from: d  reason: collision with root package name */
        R f39340d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f39341e;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r2) {
            this.f39338b = singleObserver;
            this.f39340d = r2;
            this.f39339c = biFunction;
        }

        public void dispose() {
            this.f39341e.dispose();
        }

        public boolean isDisposed() {
            return this.f39341e.isDisposed();
        }

        public void onComplete() {
            R r2 = this.f39340d;
            if (r2 != null) {
                this.f39340d = null;
                this.f39338b.onSuccess(r2);
            }
        }

        public void onError(Throwable th) {
            if (this.f39340d != null) {
                this.f39340d = null;
                this.f39338b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            R r2 = this.f39340d;
            if (r2 != null) {
                try {
                    this.f39340d = ObjectHelper.e(this.f39339c.apply(r2, t2), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39341e.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39341e, disposable)) {
                this.f39341e = disposable;
                this.f39338b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r2, BiFunction<R, ? super T, R> biFunction) {
        this.f39335b = observableSource;
        this.f39336c = r2;
        this.f39337d = biFunction;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super R> singleObserver) {
        this.f39335b.subscribe(new ReduceSeedObserver(singleObserver, this.f39337d, this.f39336c));
    }
}
