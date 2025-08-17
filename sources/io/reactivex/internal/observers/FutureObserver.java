package io.reactivex.internal.observers;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    T f38403b;

    /* renamed from: c  reason: collision with root package name */
    Throwable f38404c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<Disposable> f38405d = new AtomicReference<>();

    public FutureObserver() {
        super(1);
    }

    public boolean cancel(boolean z2) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f38405d.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!f.a(this.f38405d, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    public void dispose() {
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f38404c;
            if (th == null) {
                return this.f38403b;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.b(this.f38405d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        Disposable disposable;
        if (this.f38403b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = this.f38405d.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!f.a(this.f38405d, disposable, this));
        countDown();
    }

    public void onError(Throwable th) {
        Disposable disposable;
        if (this.f38404c == null) {
            this.f38404c = th;
            do {
                disposable = this.f38405d.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.s(th);
                    return;
                }
            } while (!f.a(this.f38405d, disposable, this));
            countDown();
            return;
        }
        RxJavaPlugins.s(th);
    }

    public void onNext(T t2) {
        if (this.f38403b != null) {
            this.f38405d.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f38403b = t2;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.f(this.f38405d, disposable);
    }

    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.b();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.c(j2, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f38404c;
            if (th == null) {
                return this.f38403b;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
