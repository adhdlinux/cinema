package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f39625c;

    static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39626b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f39627c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39628d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39629e;

        TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f39626b = observer;
            this.f39627c = predicate;
        }

        public void dispose() {
            this.f39628d.dispose();
        }

        public boolean isDisposed() {
            return this.f39628d.isDisposed();
        }

        public void onComplete() {
            if (!this.f39629e) {
                this.f39629e = true;
                this.f39626b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.f39629e) {
                this.f39629e = true;
                this.f39626b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (!this.f39629e) {
                this.f39626b.onNext(t2);
                try {
                    if (this.f39627c.test(t2)) {
                        this.f39629e = true;
                        this.f39628d.dispose();
                        this.f39626b.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39628d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39628d, disposable)) {
                this.f39628d = disposable;
                this.f39626b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f39625c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeUntilPredicateObserver(observer, this.f39625c));
    }
}
