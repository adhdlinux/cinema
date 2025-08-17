package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39032b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f39033c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39034d;

    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final CompletableObserver f39035b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicThrowable f39036c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f39037d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f39038e;

        /* renamed from: f  reason: collision with root package name */
        final CompositeDisposable f39039f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        Disposable f39040g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39041h;

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
                FlatMapCompletableMainObserver.this.b(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z2) {
            this.f39035b = completableObserver;
            this.f39037d = function;
            this.f39038e = z2;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f39039f.c(innerObserver);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.f39039f.c(innerObserver);
            onError(th);
        }

        public void dispose() {
            this.f39041h = true;
            this.f39040g.dispose();
            this.f39039f.dispose();
        }

        public boolean isDisposed() {
            return this.f39040g.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f39036c.b();
                if (b2 != null) {
                    this.f39035b.onError(b2);
                } else {
                    this.f39035b.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.f39036c.a(th)) {
                RxJavaPlugins.s(th);
            } else if (!this.f39038e) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f39035b.onError(this.f39036c.b());
                }
            } else if (decrementAndGet() == 0) {
                this.f39035b.onError(this.f39036c.b());
            }
        }

        public void onNext(T t2) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f39037d.apply(t2), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f39041h && this.f39039f.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39040g.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39040g, disposable)) {
                this.f39040g = disposable;
                this.f39035b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z2) {
        this.f39032b = observableSource;
        this.f39033c = function;
        this.f39034d = z2;
    }

    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableFlatMapCompletable(this.f39032b, this.f39033c, this.f39034d));
    }

    /* access modifiers changed from: protected */
    public void c(CompletableObserver completableObserver) {
        this.f39032b.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.f39033c, this.f39034d));
    }
}
