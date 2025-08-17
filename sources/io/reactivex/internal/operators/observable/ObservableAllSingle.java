package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38644b;

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f38645c;

    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super Boolean> f38646b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f38647c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38648d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38649e;

        AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f38646b = singleObserver;
            this.f38647c = predicate;
        }

        public void dispose() {
            this.f38648d.dispose();
        }

        public boolean isDisposed() {
            return this.f38648d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38649e) {
                this.f38649e = true;
                this.f38646b.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th) {
            if (this.f38649e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38649e = true;
            this.f38646b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38649e) {
                try {
                    if (!this.f38647c.test(t2)) {
                        this.f38649e = true;
                        this.f38648d.dispose();
                        this.f38646b.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38648d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38648d, disposable)) {
                this.f38648d = disposable;
                this.f38646b.onSubscribe(this);
            }
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f38644b = observableSource;
        this.f38645c = predicate;
    }

    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableAll(this.f38644b, this.f38645c));
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super Boolean> singleObserver) {
        this.f38644b.subscribe(new AllObserver(singleObserver, this.f38645c));
    }
}
