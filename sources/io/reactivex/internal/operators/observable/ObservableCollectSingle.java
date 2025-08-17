package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38783b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends U> f38784c;

    /* renamed from: d  reason: collision with root package name */
    final BiConsumer<? super U, ? super T> f38785d;

    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super U> f38786b;

        /* renamed from: c  reason: collision with root package name */
        final BiConsumer<? super U, ? super T> f38787c;

        /* renamed from: d  reason: collision with root package name */
        final U f38788d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f38789e;

        /* renamed from: f  reason: collision with root package name */
        boolean f38790f;

        CollectObserver(SingleObserver<? super U> singleObserver, U u2, BiConsumer<? super U, ? super T> biConsumer) {
            this.f38786b = singleObserver;
            this.f38787c = biConsumer;
            this.f38788d = u2;
        }

        public void dispose() {
            this.f38789e.dispose();
        }

        public boolean isDisposed() {
            return this.f38789e.isDisposed();
        }

        public void onComplete() {
            if (!this.f38790f) {
                this.f38790f = true;
                this.f38786b.onSuccess(this.f38788d);
            }
        }

        public void onError(Throwable th) {
            if (this.f38790f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38790f = true;
            this.f38786b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38790f) {
                try {
                    this.f38787c.accept(this.f38788d, t2);
                } catch (Throwable th) {
                    this.f38789e.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38789e, disposable)) {
                this.f38789e = disposable;
                this.f38786b.onSubscribe(this);
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f38783b = observableSource;
        this.f38784c = callable;
        this.f38785d = biConsumer;
    }

    public Observable<U> b() {
        return RxJavaPlugins.n(new ObservableCollect(this.f38783b, this.f38784c, this.f38785d));
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super U> singleObserver) {
        try {
            this.f38783b.subscribe(new CollectObserver(singleObserver, ObjectHelper.e(this.f38784c.call(), "The initialSupplier returned a null value"), this.f38785d));
        } catch (Throwable th) {
            EmptyDisposable.f(th, singleObserver);
        }
    }
}
