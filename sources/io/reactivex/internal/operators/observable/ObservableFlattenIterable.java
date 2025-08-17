package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends Iterable<? extends R>> f39067c;

    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39068b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends Iterable<? extends R>> f39069c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39070d;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f39068b = observer;
            this.f39069c = function;
        }

        public void dispose() {
            this.f39070d.dispose();
            this.f39070d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f39070d.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f39070d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f39070d = disposableHelper;
                this.f39068b.onComplete();
            }
        }

        public void onError(Throwable th) {
            Disposable disposable = this.f39070d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39070d = disposableHelper;
            this.f39068b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39070d != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.f39068b;
                    for (Object e2 : (Iterable) this.f39069c.apply(t2)) {
                        try {
                            try {
                                observer.onNext(ObjectHelper.e(e2, "The iterator returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.f39070d.dispose();
                                onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.f39070d.dispose();
                            onError(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    this.f39070d.dispose();
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39070d, disposable)) {
                this.f39070d = disposable;
                this.f39068b.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f39067c = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        this.f38612b.subscribe(new FlattenIterableObserver(observer, this.f39067c));
    }
}
