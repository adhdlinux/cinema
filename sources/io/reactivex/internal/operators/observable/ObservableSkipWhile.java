package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f39556c;

    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39557b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f39558c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39559d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39560e;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f39557b = observer;
            this.f39558c = predicate;
        }

        public void dispose() {
            this.f39559d.dispose();
        }

        public boolean isDisposed() {
            return this.f39559d.isDisposed();
        }

        public void onComplete() {
            this.f39557b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39557b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39560e) {
                this.f39557b.onNext(t2);
                return;
            }
            try {
                if (!this.f39558c.test(t2)) {
                    this.f39560e = true;
                    this.f39557b.onNext(t2);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39559d.dispose();
                this.f39557b.onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39559d, disposable)) {
                this.f39559d = disposable;
                this.f39557b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f39556c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new SkipWhileObserver(observer, this.f39556c));
    }
}
