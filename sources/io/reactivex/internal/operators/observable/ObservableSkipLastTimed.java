package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39530c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39531d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f39532e;

    /* renamed from: f  reason: collision with root package name */
    final int f39533f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f39534g;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39535b;

        /* renamed from: c  reason: collision with root package name */
        final long f39536c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39537d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler f39538e;

        /* renamed from: f  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f39539f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f39540g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f39541h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39542i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39543j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f39544k;

        SkipLastTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z2) {
            this.f39535b = observer;
            this.f39536c = j2;
            this.f39537d = timeUnit;
            this.f39538e = scheduler;
            this.f39539f = new SpscLinkedArrayQueue<>(i2);
            this.f39540g = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.f39535b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39539f;
                boolean z3 = this.f39540g;
                TimeUnit timeUnit = this.f39537d;
                Scheduler scheduler = this.f39538e;
                long j2 = this.f39536c;
                int i2 = 1;
                while (!this.f39542i) {
                    boolean z4 = this.f39543j;
                    Long l2 = (Long) spscLinkedArrayQueue.n();
                    if (l2 == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    long b2 = scheduler.b(timeUnit);
                    if (!z2 && l2.longValue() > b2 - j2) {
                        z2 = true;
                    }
                    if (z4) {
                        if (!z3) {
                            Throwable th = this.f39544k;
                            if (th != null) {
                                this.f39539f.clear();
                                observer.onError(th);
                                return;
                            } else if (z2) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z2) {
                            Throwable th2 = this.f39544k;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                this.f39539f.clear();
            }
        }

        public void dispose() {
            if (!this.f39542i) {
                this.f39542i = true;
                this.f39541h.dispose();
                if (getAndIncrement() == 0) {
                    this.f39539f.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39542i;
        }

        public void onComplete() {
            this.f39543j = true;
            a();
        }

        public void onError(Throwable th) {
            this.f39544k = th;
            this.f39543j = true;
            a();
        }

        public void onNext(T t2) {
            this.f39539f.m(Long.valueOf(this.f39538e.b(this.f39537d)), t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39541h, disposable)) {
                this.f39541h = disposable;
                this.f39535b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z2) {
        super(observableSource);
        this.f39530c = j2;
        this.f39531d = timeUnit;
        this.f39532e = scheduler;
        this.f39533f = i2;
        this.f39534g = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new SkipLastTimedObserver(observer, this.f39530c, this.f39531d, this.f39532e, this.f39533f, this.f39534g));
    }
}
