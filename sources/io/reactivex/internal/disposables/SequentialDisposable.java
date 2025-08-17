package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    public SequentialDisposable() {
    }

    public boolean a(Disposable disposable) {
        return DisposableHelper.c(this, disposable);
    }

    public boolean b(Disposable disposable) {
        return DisposableHelper.e(this, disposable);
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.b((Disposable) get());
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }
}
