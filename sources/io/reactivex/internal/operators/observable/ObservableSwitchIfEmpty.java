package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends T> f39566c;

    static final class SwitchIfEmptyObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39567b;

        /* renamed from: c  reason: collision with root package name */
        final ObservableSource<? extends T> f39568c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f39569d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        boolean f39570e = true;

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f39567b = observer;
            this.f39568c = observableSource;
        }

        public void onComplete() {
            if (this.f39570e) {
                this.f39570e = false;
                this.f39568c.subscribe(this);
                return;
            }
            this.f39567b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39567b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39570e) {
                this.f39570e = false;
            }
            this.f39567b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39569d.b(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f39566c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f39566c);
        observer.onSubscribe(switchIfEmptyObserver.f39569d);
        this.f38612b.subscribe(switchIfEmptyObserver);
    }
}
