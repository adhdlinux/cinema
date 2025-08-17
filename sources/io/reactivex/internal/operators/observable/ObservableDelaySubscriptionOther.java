package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T> f38920b;

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<U> f38921c;

    final class DelayObserver implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        final SequentialDisposable f38922b;

        /* renamed from: c  reason: collision with root package name */
        final Observer<? super T> f38923c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38924d;

        final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            public void onComplete() {
                DelayObserver.this.f38923c.onComplete();
            }

            public void onError(Throwable th) {
                DelayObserver.this.f38923c.onError(th);
            }

            public void onNext(T t2) {
                DelayObserver.this.f38923c.onNext(t2);
            }

            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.f38922b.b(disposable);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f38922b = sequentialDisposable;
            this.f38923c = observer;
        }

        public void onComplete() {
            if (!this.f38924d) {
                this.f38924d = true;
                ObservableDelaySubscriptionOther.this.f38920b.subscribe(new OnComplete());
            }
        }

        public void onError(Throwable th) {
            if (this.f38924d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38924d = true;
            this.f38923c.onError(th);
        }

        public void onNext(U u2) {
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            this.f38922b.b(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f38920b = observableSource;
        this.f38921c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f38921c.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
