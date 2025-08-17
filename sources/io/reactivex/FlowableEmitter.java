package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface FlowableEmitter<T> extends Emitter<T> {
    void a(Disposable disposable);

    boolean isCancelled();
}
