package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super Throwable, ? extends T> f39296c;

    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39297b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super Throwable, ? extends T> f39298c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39299d;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f39297b = observer;
            this.f39298c = function;
        }

        public void dispose() {
            this.f39299d.dispose();
        }

        public boolean isDisposed() {
            return this.f39299d.isDisposed();
        }

        public void onComplete() {
            this.f39297b.onComplete();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.f39298c.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f39297b.onError(nullPointerException);
                    return;
                }
                this.f39297b.onNext(apply);
                this.f39297b.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f39297b.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t2) {
            this.f39297b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39299d, disposable)) {
                this.f39299d = disposable;
                this.f39297b.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f39296c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new OnErrorReturnObserver(observer, this.f39296c));
    }
}
