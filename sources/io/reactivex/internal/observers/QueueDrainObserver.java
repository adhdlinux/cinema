package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {

    /* renamed from: c  reason: collision with root package name */
    protected final Observer<? super V> f38415c;

    /* renamed from: d  reason: collision with root package name */
    protected final SimplePlainQueue<U> f38416d;

    /* renamed from: e  reason: collision with root package name */
    protected volatile boolean f38417e;

    /* renamed from: f  reason: collision with root package name */
    protected volatile boolean f38418f;

    /* renamed from: g  reason: collision with root package name */
    protected Throwable f38419g;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f38415c = observer;
        this.f38416d = simplePlainQueue;
    }

    public void a(Observer<? super V> observer, U u2) {
    }

    public final int b(int i2) {
        return this.f38420b.addAndGet(i2);
    }

    public final boolean c() {
        return this.f38418f;
    }

    public final boolean d() {
        return this.f38417e;
    }

    public final Throwable e() {
        return this.f38419g;
    }

    public final boolean f() {
        return this.f38420b.getAndIncrement() == 0;
    }

    public final boolean g() {
        return this.f38420b.get() == 0 && this.f38420b.compareAndSet(0, 1);
    }

    /* access modifiers changed from: protected */
    public final void h(U u2, boolean z2, Disposable disposable) {
        Observer<? super V> observer = this.f38415c;
        SimplePlainQueue<U> simplePlainQueue = this.f38416d;
        if (this.f38420b.get() != 0 || !this.f38420b.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u2);
            if (!f()) {
                return;
            }
        } else {
            a(observer, u2);
            if (b(-1) == 0) {
                return;
            }
        }
        QueueDrainHelper.c(simplePlainQueue, observer, z2, disposable, this);
    }

    /* access modifiers changed from: protected */
    public final void i(U u2, boolean z2, Disposable disposable) {
        Observer<? super V> observer = this.f38415c;
        SimplePlainQueue<U> simplePlainQueue = this.f38416d;
        if (this.f38420b.get() != 0 || !this.f38420b.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u2);
            if (!f()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            a(observer, u2);
            if (b(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u2);
        }
        QueueDrainHelper.c(simplePlainQueue, observer, z2, disposable, this);
    }
}
