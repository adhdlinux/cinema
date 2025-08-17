package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    public ArrayCompositeDisposable(int i2) {
        super(i2);
    }

    public boolean a(int i2, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) get(i2);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.dispose();
                return false;
            }
        } while (!compareAndSet(i2, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    public void dispose() {
        Disposable disposable;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                Disposable disposable2 = (Disposable) get(i2);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (!(disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(i2, disposableHelper)) == disposableHelper || disposable == null)) {
                    disposable.dispose();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }
}
