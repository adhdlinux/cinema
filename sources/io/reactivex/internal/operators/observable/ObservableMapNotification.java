package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f39233c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> f39234d;

    /* renamed from: e  reason: collision with root package name */
    final Callable<? extends ObservableSource<? extends R>> f39235e;

    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super ObservableSource<? extends R>> f39236b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f39237c;

        /* renamed from: d  reason: collision with root package name */
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> f39238d;

        /* renamed from: e  reason: collision with root package name */
        final Callable<? extends ObservableSource<? extends R>> f39239e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39240f;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.f39236b = observer;
            this.f39237c = function;
            this.f39238d = function2;
            this.f39239e = callable;
        }

        public void dispose() {
            this.f39240f.dispose();
        }

        public boolean isDisposed() {
            return this.f39240f.isDisposed();
        }

        public void onComplete() {
            try {
                this.f39236b.onNext((ObservableSource) ObjectHelper.e(this.f39239e.call(), "The onComplete ObservableSource returned is null"));
                this.f39236b.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39236b.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                this.f39236b.onNext((ObservableSource) ObjectHelper.e(this.f39238d.apply(th), "The onError ObservableSource returned is null"));
                this.f39236b.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f39236b.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t2) {
            try {
                this.f39236b.onNext((ObservableSource) ObjectHelper.e(this.f39237c.apply(t2), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39236b.onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39240f, disposable)) {
                this.f39240f = disposable;
                this.f39236b.onSubscribe(this);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.f39233c = function;
        this.f39234d = function2;
        this.f39235e = callable;
    }

    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.f38612b.subscribe(new MapNotificationObserver(observer, this.f39233c, this.f39234d, this.f39235e));
    }
}
