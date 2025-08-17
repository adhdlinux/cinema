package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38975b;

    /* renamed from: c  reason: collision with root package name */
    final long f38976c;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final MaybeObserver<? super T> f38977b;

        /* renamed from: c  reason: collision with root package name */
        final long f38978c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38979d;

        /* renamed from: e  reason: collision with root package name */
        long f38980e;

        /* renamed from: f  reason: collision with root package name */
        boolean f38981f;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j2) {
            this.f38977b = maybeObserver;
            this.f38978c = j2;
        }

        public void dispose() {
            this.f38979d.dispose();
        }

        public boolean isDisposed() {
            return this.f38979d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38981f) {
                this.f38981f = true;
                this.f38977b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38981f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38981f = true;
            this.f38977b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38981f) {
                long j2 = this.f38980e;
                if (j2 == this.f38978c) {
                    this.f38981f = true;
                    this.f38979d.dispose();
                    this.f38977b.onSuccess(t2);
                    return;
                }
                this.f38980e = j2 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38979d, disposable)) {
                this.f38979d = disposable;
                this.f38977b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j2) {
        this.f38975b = observableSource;
        this.f38976c = j2;
    }

    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableElementAt(this.f38975b, this.f38976c, null, false));
    }

    public void f(MaybeObserver<? super T> maybeObserver) {
        this.f38975b.subscribe(new ElementAtObserver(maybeObserver, this.f38976c));
    }
}
