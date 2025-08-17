package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {

    /* renamed from: b  reason: collision with root package name */
    protected final Observer<? super R> f38376b;

    /* renamed from: c  reason: collision with root package name */
    protected Disposable f38377c;

    /* renamed from: d  reason: collision with root package name */
    protected QueueDisposable<T> f38378d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f38379e;

    /* renamed from: f  reason: collision with root package name */
    protected int f38380f;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.f38376b = observer;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void clear() {
        this.f38378d.clear();
    }

    /* access modifiers changed from: protected */
    public final void d(Throwable th) {
        Exceptions.b(th);
        this.f38377c.dispose();
        onError(th);
    }

    public void dispose() {
        this.f38377c.dispose();
    }

    /* access modifiers changed from: protected */
    public final int e(int i2) {
        QueueDisposable<T> queueDisposable = this.f38378d;
        if (queueDisposable == null || (i2 & 4) != 0) {
            return 0;
        }
        int b2 = queueDisposable.b(i2);
        if (b2 != 0) {
            this.f38380f = b2;
        }
        return b2;
    }

    public boolean isDisposed() {
        return this.f38377c.isDisposed();
    }

    public boolean isEmpty() {
        return this.f38378d.isEmpty();
    }

    public final boolean offer(R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f38379e) {
            this.f38379e = true;
            this.f38376b.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.f38379e) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f38379e = true;
        this.f38376b.onError(th);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.h(this.f38377c, disposable)) {
            this.f38377c = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f38378d = (QueueDisposable) disposable;
            }
            if (c()) {
                this.f38376b.onSubscribe(this);
                a();
            }
        }
    }
}
