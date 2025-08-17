package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Disposable> f40089b = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void dispose() {
        DisposableHelper.a(this.f40089b);
    }

    public final boolean isDisposed() {
        return this.f40089b.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.c(this.f40089b, disposable, getClass())) {
            a();
        }
    }
}
