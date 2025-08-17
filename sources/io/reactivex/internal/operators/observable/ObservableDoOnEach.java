package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super T> f38952c;

    /* renamed from: d  reason: collision with root package name */
    final Consumer<? super Throwable> f38953d;

    /* renamed from: e  reason: collision with root package name */
    final Action f38954e;

    /* renamed from: f  reason: collision with root package name */
    final Action f38955f;

    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38956b;

        /* renamed from: c  reason: collision with root package name */
        final Consumer<? super T> f38957c;

        /* renamed from: d  reason: collision with root package name */
        final Consumer<? super Throwable> f38958d;

        /* renamed from: e  reason: collision with root package name */
        final Action f38959e;

        /* renamed from: f  reason: collision with root package name */
        final Action f38960f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f38961g;

        /* renamed from: h  reason: collision with root package name */
        boolean f38962h;

        DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f38956b = observer;
            this.f38957c = consumer;
            this.f38958d = consumer2;
            this.f38959e = action;
            this.f38960f = action2;
        }

        public void dispose() {
            this.f38961g.dispose();
        }

        public boolean isDisposed() {
            return this.f38961g.isDisposed();
        }

        public void onComplete() {
            if (!this.f38962h) {
                try {
                    this.f38959e.run();
                    this.f38962h = true;
                    this.f38956b.onComplete();
                    try {
                        this.f38960f.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        RxJavaPlugins.s(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f38962h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38962h = true;
            try {
                this.f38958d.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f38956b.onError(th);
            try {
                this.f38960f.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        public void onNext(T t2) {
            if (!this.f38962h) {
                try {
                    this.f38957c.accept(t2);
                    this.f38956b.onNext(t2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38961g.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38961g, disposable)) {
                this.f38961g = disposable;
                this.f38956b.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f38952c = consumer;
        this.f38953d = consumer2;
        this.f38954e = action;
        this.f38955f = action2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DoOnEachObserver(observer, this.f38952c, this.f38953d, this.f38954e, this.f38955f));
    }
}
