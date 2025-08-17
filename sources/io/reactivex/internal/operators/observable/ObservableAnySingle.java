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

public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38664b;

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f38665c;

    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super Boolean> f38666b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f38667c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38668d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38669e;

        AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f38666b = singleObserver;
            this.f38667c = predicate;
        }

        public void dispose() {
            this.f38668d.dispose();
        }

        public boolean isDisposed() {
            return this.f38668d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38669e) {
                this.f38669e = true;
                this.f38666b.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th) {
            if (this.f38669e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38669e = true;
            this.f38666b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38669e) {
                try {
                    if (this.f38667c.test(t2)) {
                        this.f38669e = true;
                        this.f38668d.dispose();
                        this.f38666b.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38668d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38668d, disposable)) {
                this.f38668d = disposable;
                this.f38666b.onSubscribe(this);
            }
        }
    }

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f38664b = observableSource;
        this.f38665c = predicate;
    }

    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableAny(this.f38664b, this.f38665c));
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super Boolean> singleObserver) {
        this.f38664b.subscribe(new AnyObserver(singleObserver, this.f38665c));
    }
}
