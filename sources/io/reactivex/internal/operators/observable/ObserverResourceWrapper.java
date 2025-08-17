package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Observer<? super T> f39891b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Disposable> f39892c = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.f39891b = observer;
    }

    public void a(Disposable disposable) {
        DisposableHelper.e(this, disposable);
    }

    public void dispose() {
        DisposableHelper.a(this.f39892c);
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return this.f39892c.get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        dispose();
        this.f39891b.onComplete();
    }

    public void onError(Throwable th) {
        dispose();
        this.f39891b.onError(th);
    }

    public void onNext(T t2) {
        this.f39891b.onNext(t2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.f(this.f39892c, disposable)) {
            this.f39891b.onSubscribe(this);
        }
    }
}
