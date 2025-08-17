package io.reactivex.disposables;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
