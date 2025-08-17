package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39510b;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final MaybeObserver<? super T> f39511b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39512c;

        /* renamed from: d  reason: collision with root package name */
        T f39513d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39514e;

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.f39511b = maybeObserver;
        }

        public void dispose() {
            this.f39512c.dispose();
        }

        public boolean isDisposed() {
            return this.f39512c.isDisposed();
        }

        public void onComplete() {
            if (!this.f39514e) {
                this.f39514e = true;
                T t2 = this.f39513d;
                this.f39513d = null;
                if (t2 == null) {
                    this.f39511b.onComplete();
                } else {
                    this.f39511b.onSuccess(t2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f39514e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39514e = true;
            this.f39511b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39514e) {
                if (this.f39513d != null) {
                    this.f39514e = true;
                    this.f39512c.dispose();
                    this.f39511b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f39513d = t2;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39512c, disposable)) {
                this.f39512c = disposable;
                this.f39511b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f39510b = observableSource;
    }

    public void f(MaybeObserver<? super T> maybeObserver) {
        this.f39510b.subscribe(new SingleElementObserver(maybeObserver));
    }
}
