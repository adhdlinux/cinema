package io.reactivex.internal.operators.flowable;

import androidx.media3.exoplayer.mediacodec.f;
import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f38435d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f38436e;

    /* renamed from: f  reason: collision with root package name */
    final int f38437f;

    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super R> f38438b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f38439c;

        /* renamed from: d  reason: collision with root package name */
        final int f38440d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f38441e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final CompositeDisposable f38442f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f38443g = new AtomicInteger(1);

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f38444h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f38445i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f38446j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        Subscription f38447k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f38448l;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.b((Disposable) get());
            }

            public void onComplete() {
                FlatMapMaybeSubscriber.this.g(this);
            }

            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.h(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(R r2) {
                FlatMapMaybeSubscriber.this.i(this, r2);
            }
        }

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2, int i2) {
            this.f38438b = subscriber;
            this.f38445i = function;
            this.f38439c = z2;
            this.f38440d = i2;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38447k, subscription)) {
                this.f38447k = subscription;
                this.f38438b.a(this);
                int i2 = this.f38440d;
                if (i2 == Integer.MAX_VALUE) {
                    subscription.request(Clock.MAX_TIME);
                } else {
                    subscription.request((long) i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f38446j.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void cancel() {
            this.f38448l = true;
            this.f38447k.cancel();
            this.f38442f.dispose();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            boolean z2;
            int i2;
            boolean z3;
            boolean z4;
            Object obj;
            boolean z5;
            Subscriber<? super R> subscriber = this.f38438b;
            AtomicInteger atomicInteger = this.f38443g;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f38446j;
            int i3 = 1;
            do {
                long j2 = this.f38441e.get();
                long j3 = 0;
                while (true) {
                    z2 = false;
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.f38448l) {
                        b();
                        return;
                    } else if (this.f38439c || ((Throwable) this.f38444h.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                        if (spscLinkedArrayQueue != null) {
                            obj = spscLinkedArrayQueue.poll();
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z4 && z5) {
                            Throwable b2 = this.f38444h.b();
                            if (b2 != null) {
                                subscriber.onError(b2);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (z5) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j3++;
                        }
                    } else {
                        Throwable b3 = this.f38444h.b();
                        b();
                        subscriber.onError(b3);
                        return;
                    }
                }
                if (i2 == 0) {
                    if (this.f38448l) {
                        b();
                        return;
                    } else if (this.f38439c || ((Throwable) this.f38444h.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = atomicReference.get();
                        if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                            z2 = true;
                        }
                        if (z3 && z2) {
                            Throwable b4 = this.f38444h.b();
                            if (b4 != null) {
                                subscriber.onError(b4);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable b5 = this.f38444h.b();
                        b();
                        subscriber.onError(b5);
                        return;
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.c(this.f38441e, j3);
                    if (this.f38440d != Integer.MAX_VALUE) {
                        this.f38447k.request(j3);
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        /* access modifiers changed from: package-private */
        public SpscLinkedArrayQueue<R> f() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f38446j.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.b());
            } while (!f.a(this.f38446j, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void g(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.f38442f.c(innerObserver);
            if (get() == 0) {
                boolean z2 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f38443g.decrementAndGet() == 0) {
                        z2 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f38446j.get();
                    if (!z2 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (this.f38440d != Integer.MAX_VALUE) {
                            this.f38447k.request(1);
                        }
                        if (decrementAndGet() != 0) {
                            e();
                            return;
                        }
                        return;
                    }
                    Throwable b2 = this.f38444h.b();
                    if (b2 != null) {
                        this.f38438b.onError(b2);
                        return;
                    } else {
                        this.f38438b.onComplete();
                        return;
                    }
                }
            }
            this.f38443g.decrementAndGet();
            if (this.f38440d != Integer.MAX_VALUE) {
                this.f38447k.request(1);
            }
            d();
        }

        /* access modifiers changed from: package-private */
        public void h(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f38442f.c(innerObserver);
            if (this.f38444h.a(th)) {
                if (!this.f38439c) {
                    this.f38447k.cancel();
                    this.f38442f.dispose();
                } else if (this.f38440d != Integer.MAX_VALUE) {
                    this.f38447k.request(1);
                }
                this.f38443g.decrementAndGet();
                d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void i(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r2) {
            this.f38442f.c(innerObserver);
            if (get() == 0) {
                boolean z2 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f38443g.decrementAndGet() == 0) {
                        z2 = true;
                    }
                    if (this.f38441e.get() != 0) {
                        this.f38438b.onNext(r2);
                        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f38446j.get();
                        if (!z2 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            BackpressureHelper.c(this.f38441e, 1);
                            if (this.f38440d != Integer.MAX_VALUE) {
                                this.f38447k.request(1);
                            }
                        } else {
                            Throwable b2 = this.f38444h.b();
                            if (b2 != null) {
                                this.f38438b.onError(b2);
                                return;
                            } else {
                                this.f38438b.onComplete();
                                return;
                            }
                        }
                    } else {
                        SpscLinkedArrayQueue f2 = f();
                        synchronized (f2) {
                            f2.offer(r2);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    e();
                }
            }
            SpscLinkedArrayQueue f3 = f();
            synchronized (f3) {
                f3.offer(r2);
            }
            this.f38443g.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            e();
        }

        public void onComplete() {
            this.f38443g.decrementAndGet();
            d();
        }

        public void onError(Throwable th) {
            this.f38443g.decrementAndGet();
            if (this.f38444h.a(th)) {
                if (!this.f38439c) {
                    this.f38442f.dispose();
                }
                d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f38445i.apply(t2), "The mapper returned a null MaybeSource");
                this.f38443g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f38448l && this.f38442f.b(innerObserver)) {
                    maybeSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38447k.cancel();
                onError(th);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this.f38441e, j2);
                d();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2, int i2) {
        super(flowable);
        this.f38435d = function;
        this.f38436e = z2;
        this.f38437f = i2;
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super R> subscriber) {
        this.f38421c.n(new FlatMapMaybeSubscriber(subscriber, this.f38435d, this.f38436e, this.f38437f));
    }
}
