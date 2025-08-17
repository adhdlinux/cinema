package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f39022c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39023d;

    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39024b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicThrowable f39025c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f39026d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f39027e;

        /* renamed from: f  reason: collision with root package name */
        final CompositeDisposable f39028f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        Disposable f39029g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39030h;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.b((Disposable) get());
            }

            public void onComplete() {
                FlatMapCompletableMainObserver.this.a(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.c(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z2) {
            this.f39024b = observer;
            this.f39026d = function;
            this.f39027e = z2;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f39028f.c(innerObserver);
            onComplete();
        }

        public int b(int i2) {
            return i2 & 2;
        }

        /* access modifiers changed from: package-private */
        public void c(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.f39028f.c(innerObserver);
            onError(th);
        }

        public void clear() {
        }

        public void dispose() {
            this.f39030h = true;
            this.f39029g.dispose();
            this.f39028f.dispose();
        }

        public boolean isDisposed() {
            return this.f39029g.isDisposed();
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f39025c.b();
                if (b2 != null) {
                    this.f39024b.onError(b2);
                } else {
                    this.f39024b.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.f39025c.a(th)) {
                RxJavaPlugins.s(th);
            } else if (!this.f39027e) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f39024b.onError(this.f39025c.b());
                }
            } else if (decrementAndGet() == 0) {
                this.f39024b.onError(this.f39025c.b());
            }
        }

        public void onNext(T t2) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f39026d.apply(t2), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f39030h && this.f39028f.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39029g.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39029g, disposable)) {
                this.f39029g = disposable;
                this.f39024b.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            return null;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z2) {
        super(observableSource);
        this.f39022c = function;
        this.f39023d = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new FlatMapCompletableMainObserver(observer, this.f39022c, this.f39023d));
    }
}
