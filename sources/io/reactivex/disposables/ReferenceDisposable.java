package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    ReferenceDisposable(T t2) {
        super(ObjectHelper.e(t2, "value is null"));
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t2);

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
