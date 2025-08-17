package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T> f39515b;

    /* renamed from: c  reason: collision with root package name */
    final T f39516c;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f39517b;

        /* renamed from: c  reason: collision with root package name */
        final T f39518c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39519d;

        /* renamed from: e  reason: collision with root package name */
        T f39520e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39521f;

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t2) {
            this.f39517b = singleObserver;
            this.f39518c = t2;
        }

        public void dispose() {
            this.f39519d.dispose();
        }

        public boolean isDisposed() {
            return this.f39519d.isDisposed();
        }

        public void onComplete() {
            if (!this.f39521f) {
                this.f39521f = true;
                T t2 = this.f39520e;
                this.f39520e = null;
                if (t2 == null) {
                    t2 = this.f39518c;
                }
                if (t2 != null) {
                    this.f39517b.onSuccess(t2);
                } else {
                    this.f39517b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f39521f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39521f = true;
            this.f39517b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39521f) {
                if (this.f39520e != null) {
                    this.f39521f = true;
                    this.f39519d.dispose();
                    this.f39517b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f39520e = t2;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39519d, disposable)) {
                this.f39519d = disposable;
                this.f39517b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t2) {
        this.f39515b = observableSource;
        this.f39516c = t2;
    }

    public void j(SingleObserver<? super T> singleObserver) {
        this.f39515b.subscribe(new SingleElementObserver(singleObserver, this.f39516c));
    }
}
