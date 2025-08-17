package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39603c;

    /* renamed from: d  reason: collision with root package name */
    final long f39604d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f39605e;

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f39606f;

    /* renamed from: g  reason: collision with root package name */
    final int f39607g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f39608h;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39609b;

        /* renamed from: c  reason: collision with root package name */
        final long f39610c;

        /* renamed from: d  reason: collision with root package name */
        final long f39611d;

        /* renamed from: e  reason: collision with root package name */
        final TimeUnit f39612e;

        /* renamed from: f  reason: collision with root package name */
        final Scheduler f39613f;

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f39614g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f39615h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f39616i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39617j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f39618k;

        TakeLastTimedObserver(Observer<? super T> observer, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z2) {
            this.f39609b = observer;
            this.f39610c = j2;
            this.f39611d = j3;
            this.f39612e = timeUnit;
            this.f39613f = scheduler;
            this.f39614g = new SpscLinkedArrayQueue<>(i2);
            this.f39615h = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.f39609b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39614g;
                boolean z3 = this.f39615h;
                while (!this.f39617j) {
                    if (z3 || (th = this.f39618k) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            Throwable th2 = this.f39618k;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= this.f39613f.b(this.f39612e) - this.f39611d) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void dispose() {
            if (!this.f39617j) {
                this.f39617j = true;
                this.f39616i.dispose();
                if (compareAndSet(false, true)) {
                    this.f39614g.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39617j;
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.f39618k = th;
            a();
        }

        public void onNext(T t2) {
            boolean z2;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39614g;
            long b2 = this.f39613f.b(this.f39612e);
            long j2 = this.f39611d;
            long j3 = this.f39610c;
            if (j3 == Clock.MAX_TIME) {
                z2 = true;
            } else {
                z2 = false;
            }
            spscLinkedArrayQueue.m(Long.valueOf(b2), t2);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.n()).longValue() <= b2 - j2 || (!z2 && ((long) (spscLinkedArrayQueue.p() >> 1)) > j3)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39616i, disposable)) {
                this.f39616i = disposable;
                this.f39609b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z2) {
        super(observableSource);
        this.f39603c = j2;
        this.f39604d = j3;
        this.f39605e = timeUnit;
        this.f39606f = scheduler;
        this.f39607g = i2;
        this.f39608h = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeLastTimedObserver(observer, this.f39603c, this.f39604d, this.f39605e, this.f39606f, this.f39607g, this.f39608h));
    }
}
