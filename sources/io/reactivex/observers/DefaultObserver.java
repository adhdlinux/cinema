package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: b  reason: collision with root package name */
    private Disposable f40088b;

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.d(this.f40088b, disposable, getClass())) {
            this.f40088b = disposable;
            a();
        }
    }
}
