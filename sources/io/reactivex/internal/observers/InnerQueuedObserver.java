package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final InnerQueuedObserverSupport<T> f38406b;

    /* renamed from: c  reason: collision with root package name */
    final int f38407c;

    /* renamed from: d  reason: collision with root package name */
    SimpleQueue<T> f38408d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f38409e;

    /* renamed from: f  reason: collision with root package name */
    int f38410f;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i2) {
        this.f38406b = innerQueuedObserverSupport;
        this.f38407c = i2;
    }

    public boolean a() {
        return this.f38409e;
    }

    public SimpleQueue<T> b() {
        return this.f38408d;
    }

    public void c() {
        this.f38409e = true;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.b((Disposable) get());
    }

    public void onComplete() {
        this.f38406b.c(this);
    }

    public void onError(Throwable th) {
        this.f38406b.b(this, th);
    }

    public void onNext(T t2) {
        if (this.f38410f == 0) {
            this.f38406b.d(this, t2);
        } else {
            this.f38406b.a();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.f(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int b2 = queueDisposable.b(3);
                if (b2 == 1) {
                    this.f38410f = b2;
                    this.f38408d = queueDisposable;
                    this.f38409e = true;
                    this.f38406b.c(this);
                    return;
                } else if (b2 == 2) {
                    this.f38410f = b2;
                    this.f38408d = queueDisposable;
                    return;
                }
            }
            this.f38408d = QueueDrainHelper.b(-this.f38407c);
        }
    }
}
