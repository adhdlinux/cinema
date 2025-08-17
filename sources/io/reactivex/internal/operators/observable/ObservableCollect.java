package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends U> f38776c;

    /* renamed from: d  reason: collision with root package name */
    final BiConsumer<? super U, ? super T> f38777d;

    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f38778b;

        /* renamed from: c  reason: collision with root package name */
        final BiConsumer<? super U, ? super T> f38779c;

        /* renamed from: d  reason: collision with root package name */
        final U f38780d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f38781e;

        /* renamed from: f  reason: collision with root package name */
        boolean f38782f;

        CollectObserver(Observer<? super U> observer, U u2, BiConsumer<? super U, ? super T> biConsumer) {
            this.f38778b = observer;
            this.f38779c = biConsumer;
            this.f38780d = u2;
        }

        public void dispose() {
            this.f38781e.dispose();
        }

        public boolean isDisposed() {
            return this.f38781e.isDisposed();
        }

        public void onComplete() {
            if (!this.f38782f) {
                this.f38782f = true;
                this.f38778b.onNext(this.f38780d);
                this.f38778b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38782f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38782f = true;
            this.f38778b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38782f) {
                try {
                    this.f38779c.accept(this.f38780d, t2);
                } catch (Throwable th) {
                    this.f38781e.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38781e, disposable)) {
                this.f38781e = disposable;
                this.f38778b.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f38776c = callable;
        this.f38777d = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f38612b.subscribe(new CollectObserver(observer, ObjectHelper.e(this.f38776c.call(), "The initialSupplier returned a null value"), this.f38777d));
        } catch (Throwable th) {
            EmptyDisposable.e(th, observer);
        }
    }
}
