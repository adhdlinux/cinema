package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f38639c;

    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Boolean> f38640b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f38641c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38642d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38643e;

        AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f38640b = observer;
            this.f38641c = predicate;
        }

        public void dispose() {
            this.f38642d.dispose();
        }

        public boolean isDisposed() {
            return this.f38642d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38643e) {
                this.f38643e = true;
                this.f38640b.onNext(Boolean.TRUE);
                this.f38640b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38643e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38643e = true;
            this.f38640b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38643e) {
                try {
                    if (!this.f38641c.test(t2)) {
                        this.f38643e = true;
                        this.f38642d.dispose();
                        this.f38640b.onNext(Boolean.FALSE);
                        this.f38640b.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38642d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38642d, disposable)) {
                this.f38642d = disposable;
                this.f38640b.onSubscribe(this);
            }
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38639c = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f38612b.subscribe(new AllObserver(observer, this.f38639c));
    }
}
