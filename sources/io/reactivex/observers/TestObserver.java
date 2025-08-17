package io.reactivex.observers;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: j  reason: collision with root package name */
    private final Observer<? super T> f40099j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicReference<Disposable> f40100k;

    /* renamed from: l  reason: collision with root package name */
    private QueueDisposable<T> f40101l;

    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public final void dispose() {
        DisposableHelper.a(this.f40100k);
    }

    public final boolean isDisposed() {
        return DisposableHelper.b(this.f40100k.get());
    }

    public void onComplete() {
        if (!this.f40085g) {
            this.f40085g = true;
            if (this.f40100k.get() == null) {
                this.f40082d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f40084f = Thread.currentThread();
            this.f40083e++;
            this.f40099j.onComplete();
        } finally {
            this.f40080b.countDown();
        }
    }

    public void onError(Throwable th) {
        if (!this.f40085g) {
            this.f40085g = true;
            if (this.f40100k.get() == null) {
                this.f40082d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f40084f = Thread.currentThread();
            if (th == null) {
                this.f40082d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f40082d.add(th);
            }
            this.f40099j.onError(th);
        } finally {
            this.f40080b.countDown();
        }
    }

    public void onNext(T t2) {
        if (!this.f40085g) {
            this.f40085g = true;
            if (this.f40100k.get() == null) {
                this.f40082d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f40084f = Thread.currentThread();
        if (this.f40087i == 2) {
            while (true) {
                try {
                    T poll = this.f40101l.poll();
                    if (poll != null) {
                        this.f40081c.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.f40082d.add(th);
                    this.f40101l.dispose();
                    return;
                }
            }
        } else {
            this.f40081c.add(t2);
            if (t2 == null) {
                this.f40082d.add(new NullPointerException("onNext received a null value"));
            }
            this.f40099j.onNext(t2);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.f40084f = Thread.currentThread();
        if (disposable == null) {
            this.f40082d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!f.a(this.f40100k, (Object) null, disposable)) {
            disposable.dispose();
            if (this.f40100k.get() != DisposableHelper.DISPOSED) {
                this.f40082d.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i2 = this.f40086h;
            if (i2 != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.f40101l = queueDisposable;
                int b2 = queueDisposable.b(i2);
                this.f40087i = b2;
                if (b2 == 1) {
                    this.f40085g = true;
                    this.f40084f = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f40101l.poll();
                            if (poll != null) {
                                this.f40081c.add(poll);
                            } else {
                                this.f40083e++;
                                this.f40100k.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.f40082d.add(th);
                            return;
                        }
                    }
                }
            }
            this.f40099j.onSubscribe(disposable);
        }
    }

    public void onSuccess(T t2) {
        onNext(t2);
        onComplete();
    }

    public TestObserver(Observer<? super T> observer) {
        this.f40100k = new AtomicReference<>();
        this.f40099j = observer;
    }
}
