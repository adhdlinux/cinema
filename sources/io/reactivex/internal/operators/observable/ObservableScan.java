package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<T, T, T> f39461c;

    static final class ScanObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39462b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<T, T, T> f39463c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39464d;

        /* renamed from: e  reason: collision with root package name */
        T f39465e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39466f;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f39462b = observer;
            this.f39463c = biFunction;
        }

        public void dispose() {
            this.f39464d.dispose();
        }

        public boolean isDisposed() {
            return this.f39464d.isDisposed();
        }

        public void onComplete() {
            if (!this.f39466f) {
                this.f39466f = true;
                this.f39462b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f39466f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39466f = true;
            this.f39462b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39466f) {
                Observer<? super T> observer = this.f39462b;
                T t3 = this.f39465e;
                if (t3 == null) {
                    this.f39465e = t2;
                    observer.onNext(t2);
                    return;
                }
                try {
                    T e2 = ObjectHelper.e(this.f39463c.apply(t3, t2), "The value returned by the accumulator is null");
                    this.f39465e = e2;
                    observer.onNext(e2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39464d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39464d, disposable)) {
                this.f39464d = disposable;
                this.f39462b.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f39461c = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ScanObserver(observer, this.f39461c));
    }
}
