package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends Notification<R>> f38927c;

    static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38928b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends Notification<R>> f38929c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38930d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f38931e;

        DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.f38928b = observer;
            this.f38929c = function;
        }

        public void dispose() {
            this.f38931e.dispose();
        }

        public boolean isDisposed() {
            return this.f38931e.isDisposed();
        }

        public void onComplete() {
            if (!this.f38930d) {
                this.f38930d = true;
                this.f38928b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38930d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38930d = true;
            this.f38928b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38930d) {
                try {
                    Notification notification = (Notification) ObjectHelper.e(this.f38929c.apply(t2), "The selector returned a null Notification");
                    if (notification.g()) {
                        this.f38931e.dispose();
                        onError(notification.d());
                    } else if (notification.f()) {
                        this.f38931e.dispose();
                        onComplete();
                    } else {
                        this.f38928b.onNext(notification.e());
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38931e.dispose();
                    onError(th);
                }
            } else if (t2 instanceof Notification) {
                Notification notification2 = (Notification) t2;
                if (notification2.g()) {
                    RxJavaPlugins.s(notification2.d());
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38931e, disposable)) {
                this.f38931e = disposable;
                this.f38928b.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.f38927c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f38612b.subscribe(new DematerializeObserver(observer, this.f38927c));
    }
}
