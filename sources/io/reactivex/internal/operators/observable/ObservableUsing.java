package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends D> f39723b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super D, ? extends ObservableSource<? extends T>> f39724c;

    /* renamed from: d  reason: collision with root package name */
    final Consumer<? super D> f39725d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f39726e;

    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39727b;

        /* renamed from: c  reason: collision with root package name */
        final D f39728c;

        /* renamed from: d  reason: collision with root package name */
        final Consumer<? super D> f39729d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f39730e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39731f;

        UsingObserver(Observer<? super T> observer, D d2, Consumer<? super D> consumer, boolean z2) {
            this.f39727b = observer;
            this.f39728c = d2;
            this.f39729d = consumer;
            this.f39730e = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f39729d.accept(this.f39728c);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        public void dispose() {
            a();
            this.f39731f.dispose();
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (this.f39730e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f39729d.accept(this.f39728c);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f39727b.onError(th);
                        return;
                    }
                }
                this.f39731f.dispose();
                this.f39727b.onComplete();
                return;
            }
            this.f39727b.onComplete();
            this.f39731f.dispose();
            a();
        }

        public void onError(Throwable th) {
            if (this.f39730e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f39729d.accept(this.f39728c);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.f39731f.dispose();
                this.f39727b.onError(th);
                return;
            }
            this.f39727b.onError(th);
            this.f39731f.dispose();
            a();
        }

        public void onNext(T t2) {
            this.f39727b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39731f, disposable)) {
                this.f39731f = disposable;
                this.f39727b.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z2) {
        this.f39723b = callable;
        this.f39724c = function;
        this.f39725d = consumer;
        this.f39726e = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f39723b.call();
            try {
                ((ObservableSource) ObjectHelper.e(this.f39724c.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.f39725d, this.f39726e));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(new CompositeException(th, th), observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.e(th2, observer);
        }
    }
}
