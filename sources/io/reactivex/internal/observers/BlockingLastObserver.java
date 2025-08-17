package io.reactivex.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th) {
        this.f38381b = null;
        this.f38382c = th;
        countDown();
    }

    public void onNext(T t2) {
        this.f38381b = t2;
    }
}
