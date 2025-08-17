package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super T> f39630c;

    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39631b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super T> f39632c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39633d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39634e;

        TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f39631b = observer;
            this.f39632c = predicate;
        }

        public void dispose() {
            this.f39633d.dispose();
        }

        public boolean isDisposed() {
            return this.f39633d.isDisposed();
        }

        public void onComplete() {
            if (!this.f39634e) {
                this.f39634e = true;
                this.f39631b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f39634e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39634e = true;
            this.f39631b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39634e) {
                try {
                    if (!this.f39632c.test(t2)) {
                        this.f39634e = true;
                        this.f39633d.dispose();
                        this.f39631b.onComplete();
                        return;
                    }
                    this.f39631b.onNext(t2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39633d.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39633d, disposable)) {
                this.f39633d = disposable;
                this.f39631b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f39630c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeWhileObserver(observer, this.f39630c));
    }
}
