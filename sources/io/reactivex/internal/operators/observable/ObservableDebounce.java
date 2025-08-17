package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<U>> f38877c;

    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38878b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<U>> f38879c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38880d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Disposable> f38881e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        volatile long f38882f;

        /* renamed from: g  reason: collision with root package name */
        boolean f38883g;

        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {

            /* renamed from: c  reason: collision with root package name */
            final DebounceObserver<T, U> f38884c;

            /* renamed from: d  reason: collision with root package name */
            final long f38885d;

            /* renamed from: e  reason: collision with root package name */
            final T f38886e;

            /* renamed from: f  reason: collision with root package name */
            boolean f38887f;

            /* renamed from: g  reason: collision with root package name */
            final AtomicBoolean f38888g = new AtomicBoolean();

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j2, T t2) {
                this.f38884c = debounceObserver;
                this.f38885d = j2;
                this.f38886e = t2;
            }

            /* access modifiers changed from: package-private */
            public void b() {
                if (this.f38888g.compareAndSet(false, true)) {
                    this.f38884c.a(this.f38885d, this.f38886e);
                }
            }

            public void onComplete() {
                if (!this.f38887f) {
                    this.f38887f = true;
                    b();
                }
            }

            public void onError(Throwable th) {
                if (this.f38887f) {
                    RxJavaPlugins.s(th);
                    return;
                }
                this.f38887f = true;
                this.f38884c.onError(th);
            }

            public void onNext(U u2) {
                if (!this.f38887f) {
                    this.f38887f = true;
                    dispose();
                    b();
                }
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f38878b = observer;
            this.f38879c = function;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t2) {
            if (j2 == this.f38882f) {
                this.f38878b.onNext(t2);
            }
        }

        public void dispose() {
            this.f38880d.dispose();
            DisposableHelper.a(this.f38881e);
        }

        public boolean isDisposed() {
            return this.f38880d.isDisposed();
        }

        public void onComplete() {
            if (!this.f38883g) {
                this.f38883g = true;
                Disposable disposable = this.f38881e.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    ((DebounceInnerObserver) disposable).b();
                    DisposableHelper.a(this.f38881e);
                    this.f38878b.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.f38881e);
            this.f38878b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38883g) {
                long j2 = this.f38882f + 1;
                this.f38882f = j2;
                Disposable disposable = this.f38881e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38879c.apply(t2), "The ObservableSource supplied is null");
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j2, t2);
                    if (f.a(this.f38881e, disposable, debounceInnerObserver)) {
                        observableSource.subscribe(debounceInnerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    this.f38878b.onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38880d, disposable)) {
                this.f38880d = disposable;
                this.f38878b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f38877c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DebounceObserver(new SerializedObserver(observer), this.f38877c));
    }
}
