package io.reactivex.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th) {
        if (this.f38381b == null) {
            this.f38382c = th;
        }
        countDown();
    }

    public void onNext(T t2) {
        if (this.f38381b == null) {
            this.f38381b = t2;
            this.f38383d.dispose();
            countDown();
        }
    }
}
