package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    T f38381b;

    /* renamed from: c  reason: collision with root package name */
    Throwable f38382c;

    /* renamed from: d  reason: collision with root package name */
    Disposable f38383d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f38384e;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw ExceptionHelper.d(e2);
            }
        }
        Throwable th = this.f38382c;
        if (th == null) {
            return this.f38381b;
        }
        throw ExceptionHelper.d(th);
    }

    public final void dispose() {
        this.f38384e = true;
        Disposable disposable = this.f38383d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f38384e;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.f38383d = disposable;
        if (this.f38384e) {
            disposable.dispose();
        }
    }
}
