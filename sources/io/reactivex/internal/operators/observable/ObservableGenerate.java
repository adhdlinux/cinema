package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<S> f39092b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<S, Emitter<T>, S> f39093c;

    /* renamed from: d  reason: collision with root package name */
    final Consumer<? super S> f39094d;

    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39095b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<S, ? super Emitter<T>, S> f39096c;

        /* renamed from: d  reason: collision with root package name */
        final Consumer<? super S> f39097d;

        /* renamed from: e  reason: collision with root package name */
        S f39098e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39099f;

        /* renamed from: g  reason: collision with root package name */
        boolean f39100g;

        /* renamed from: h  reason: collision with root package name */
        boolean f39101h;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s2) {
            this.f39095b = observer;
            this.f39096c = biFunction;
            this.f39097d = consumer;
            this.f39098e = s2;
        }

        private void b(S s2) {
            try {
                this.f39097d.accept(s2);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        public void c(Throwable th) {
            if (this.f39100g) {
                RxJavaPlugins.s(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f39100g = true;
            this.f39095b.onError(th);
        }

        public void d() {
            S s2 = this.f39098e;
            if (this.f39099f) {
                this.f39098e = null;
                b(s2);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.f39096c;
            while (!this.f39099f) {
                this.f39101h = false;
                try {
                    s2 = biFunction.apply(s2, this);
                    if (this.f39100g) {
                        this.f39099f = true;
                        this.f39098e = null;
                        b(s2);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39098e = null;
                    this.f39099f = true;
                    c(th);
                    b(s2);
                    return;
                }
            }
            this.f39098e = null;
            b(s2);
        }

        public void dispose() {
            this.f39099f = true;
        }

        public boolean isDisposed() {
            return this.f39099f;
        }
    }

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f39092b = callable;
        this.f39093c = biFunction;
        this.f39094d = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f39093c, this.f39094d, this.f39092b.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.d();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }
}
