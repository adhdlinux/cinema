package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f38659c;

    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Boolean> f38660b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f38661c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38662d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38663e;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f38660b = observer;
            this.f38661c = predicate;
        }

        public void dispose() {
            this.f38662d.dispose();
        }

        public boolean isDisposed() {
            return this.f38662d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38663e) {
                this.f38663e = true;
                this.f38660b.onNext(Boolean.FALSE);
                this.f38660b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38663e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38663e = true;
            this.f38660b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38663e) {
                try {
                    if (this.f38661c.test(t2)) {
                        this.f38663e = true;
                        this.f38662d.dispose();
                        this.f38660b.onNext(Boolean.TRUE);
                        this.f38660b.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38662d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38662d, disposable)) {
                this.f38662d = disposable;
                this.f38660b.onSubscribe(this);
            }
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38659c = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f38612b.subscribe(new AnyObserver(observer, this.f38659c));
    }
}
