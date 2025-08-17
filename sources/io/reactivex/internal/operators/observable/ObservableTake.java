package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39590c;

    static final class TakeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39591b;

        /* renamed from: c  reason: collision with root package name */
        boolean f39592c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39593d;

        /* renamed from: e  reason: collision with root package name */
        long f39594e;

        TakeObserver(Observer<? super T> observer, long j2) {
            this.f39591b = observer;
            this.f39594e = j2;
        }

        public void dispose() {
            this.f39593d.dispose();
        }

        public boolean isDisposed() {
            return this.f39593d.isDisposed();
        }

        public void onComplete() {
            if (!this.f39592c) {
                this.f39592c = true;
                this.f39593d.dispose();
                this.f39591b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f39592c) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39592c = true;
            this.f39593d.dispose();
            this.f39591b.onError(th);
        }

        public void onNext(T t2) {
            boolean z2;
            if (!this.f39592c) {
                long j2 = this.f39594e;
                long j3 = j2 - 1;
                this.f39594e = j3;
                if (j2 > 0) {
                    if (j3 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f39591b.onNext(t2);
                    if (z2) {
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39593d, disposable)) {
                this.f39593d = disposable;
                if (this.f39594e == 0) {
                    this.f39592c = true;
                    disposable.dispose();
                    EmptyDisposable.c(this.f39591b);
                    return;
                }
                this.f39591b.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j2) {
        super(observableSource);
        this.f39590c = j2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeObserver(observer, this.f39590c));
    }
}
