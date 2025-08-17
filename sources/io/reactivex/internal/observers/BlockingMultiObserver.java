package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    T f38385b;

    /* renamed from: c  reason: collision with root package name */
    Throwable f38386c;

    /* renamed from: d  reason: collision with root package name */
    Disposable f38387d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f38388e;

    public BlockingMultiObserver() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                b();
                throw ExceptionHelper.d(e2);
            }
        }
        Throwable th = this.f38386c;
        if (th == null) {
            return this.f38385b;
        }
        throw ExceptionHelper.d(th);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f38388e = true;
        Disposable disposable = this.f38387d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th) {
        this.f38386c = th;
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        this.f38387d = disposable;
        if (this.f38388e) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t2) {
        this.f38385b = t2;
        countDown();
    }
}
