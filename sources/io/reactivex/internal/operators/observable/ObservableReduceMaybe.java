package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39328b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<T, T, T> f39329c;

    static final class ReduceObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final MaybeObserver<? super T> f39330b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<T, T, T> f39331c;

        /* renamed from: d  reason: collision with root package name */
        boolean f39332d;

        /* renamed from: e  reason: collision with root package name */
        T f39333e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39334f;

        ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f39330b = maybeObserver;
            this.f39331c = biFunction;
        }

        public void dispose() {
            this.f39334f.dispose();
        }

        public boolean isDisposed() {
            return this.f39334f.isDisposed();
        }

        public void onComplete() {
            if (!this.f39332d) {
                this.f39332d = true;
                T t2 = this.f39333e;
                this.f39333e = null;
                if (t2 != null) {
                    this.f39330b.onSuccess(t2);
                } else {
                    this.f39330b.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f39332d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39332d = true;
            this.f39333e = null;
            this.f39330b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39332d) {
                T t3 = this.f39333e;
                if (t3 == null) {
                    this.f39333e = t2;
                    return;
                }
                try {
                    this.f39333e = ObjectHelper.e(this.f39331c.apply(t3, t2), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39334f.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39334f, disposable)) {
                this.f39334f = disposable;
                this.f39330b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f39328b = observableSource;
        this.f39329c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void f(MaybeObserver<? super T> maybeObserver) {
        this.f39328b.subscribe(new ReduceObserver(maybeObserver, this.f39329c));
    }
}
