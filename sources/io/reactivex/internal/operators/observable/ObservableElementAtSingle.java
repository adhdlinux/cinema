package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38982b;

    /* renamed from: c  reason: collision with root package name */
    final long f38983c;

    /* renamed from: d  reason: collision with root package name */
    final T f38984d;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f38985b;

        /* renamed from: c  reason: collision with root package name */
        final long f38986c;

        /* renamed from: d  reason: collision with root package name */
        final T f38987d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f38988e;

        /* renamed from: f  reason: collision with root package name */
        long f38989f;

        /* renamed from: g  reason: collision with root package name */
        boolean f38990g;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j2, T t2) {
            this.f38985b = singleObserver;
            this.f38986c = j2;
            this.f38987d = t2;
        }

        public void dispose() {
            this.f38988e.dispose();
        }

        public boolean isDisposed() {
            return this.f38988e.isDisposed();
        }

        public void onComplete() {
            if (!this.f38990g) {
                this.f38990g = true;
                T t2 = this.f38987d;
                if (t2 != null) {
                    this.f38985b.onSuccess(t2);
                } else {
                    this.f38985b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f38990g) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38990g = true;
            this.f38985b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38990g) {
                long j2 = this.f38989f;
                if (j2 == this.f38986c) {
                    this.f38990g = true;
                    this.f38988e.dispose();
                    this.f38985b.onSuccess(t2);
                    return;
                }
                this.f38989f = j2 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38988e, disposable)) {
                this.f38988e = disposable;
                this.f38985b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j2, T t2) {
        this.f38982b = observableSource;
        this.f38983c = j2;
        this.f38984d = t2;
    }

    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableElementAt(this.f38982b, this.f38983c, this.f38984d, true));
    }

    public void j(SingleObserver<? super T> singleObserver) {
        this.f38982b.subscribe(new ElementAtObserver(singleObserver, this.f38983c, this.f38984d));
    }
}
