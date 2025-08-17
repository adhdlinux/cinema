package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f38389c = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Queue<Object> f38390b;

    public BlockingObserver(Queue<Object> queue) {
        this.f38390b = queue;
    }

    public void dispose() {
        if (DisposableHelper.a(this)) {
            this.f38390b.offer(f38389c);
        }
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        this.f38390b.offer(NotificationLite.c());
    }

    public void onError(Throwable th) {
        this.f38390b.offer(NotificationLite.e(th));
    }

    public void onNext(T t2) {
        this.f38390b.offer(NotificationLite.j(t2));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }
}
