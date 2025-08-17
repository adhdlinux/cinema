package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<U> f39545c;

    final class SkipUntil implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        final ArrayCompositeDisposable f39546b;

        /* renamed from: c  reason: collision with root package name */
        final SkipUntilObserver<T> f39547c;

        /* renamed from: d  reason: collision with root package name */
        final SerializedObserver<T> f39548d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f39549e;

        SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.f39546b = arrayCompositeDisposable;
            this.f39547c = skipUntilObserver;
            this.f39548d = serializedObserver;
        }

        public void onComplete() {
            this.f39547c.f39554e = true;
        }

        public void onError(Throwable th) {
            this.f39546b.dispose();
            this.f39548d.onError(th);
        }

        public void onNext(U u2) {
            this.f39549e.dispose();
            this.f39547c.f39554e = true;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39549e, disposable)) {
                this.f39549e = disposable;
                this.f39546b.a(1, disposable);
            }
        }
    }

    static final class SkipUntilObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39551b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayCompositeDisposable f39552c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39553d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39554e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39555f;

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f39551b = observer;
            this.f39552c = arrayCompositeDisposable;
        }

        public void onComplete() {
            this.f39552c.dispose();
            this.f39551b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39552c.dispose();
            this.f39551b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39555f) {
                this.f39551b.onNext(t2);
            } else if (this.f39554e) {
                this.f39555f = true;
                this.f39551b.onNext(t2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39553d, disposable)) {
                this.f39553d = disposable;
                this.f39552c.a(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f39545c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.f39545c.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.f38612b.subscribe(skipUntilObserver);
    }
}
