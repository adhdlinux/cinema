package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> f39288c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39289d;

    static final class OnErrorNextObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39290b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> f39291c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f39292d;

        /* renamed from: e  reason: collision with root package name */
        final SequentialDisposable f39293e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        boolean f39294f;

        /* renamed from: g  reason: collision with root package name */
        boolean f39295g;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z2) {
            this.f39290b = observer;
            this.f39291c = function;
            this.f39292d = z2;
        }

        public void onComplete() {
            if (!this.f39295g) {
                this.f39295g = true;
                this.f39294f = true;
                this.f39290b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.f39294f) {
                this.f39294f = true;
                if (!this.f39292d || (th instanceof Exception)) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.f39291c.apply(th);
                        if (observableSource == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th);
                            this.f39290b.onError(nullPointerException);
                            return;
                        }
                        observableSource.subscribe(this);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        this.f39290b.onError(new CompositeException(th, th2));
                    }
                } else {
                    this.f39290b.onError(th);
                }
            } else if (this.f39295g) {
                RxJavaPlugins.s(th);
            } else {
                this.f39290b.onError(th);
            }
        }

        public void onNext(T t2) {
            if (!this.f39295g) {
                this.f39290b.onNext(t2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f39293e.a(disposable);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z2) {
        super(observableSource);
        this.f39288c = function;
        this.f39289d = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.f39288c, this.f39289d);
        observer.onSubscribe(onErrorNextObserver.f39293e);
        this.f38612b.subscribe(onErrorNextObserver);
    }
}
