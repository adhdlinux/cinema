package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38496b;

        /* renamed from: c  reason: collision with root package name */
        Subscription f38497c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f38498d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f38499e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f38500f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f38501g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<T> f38502h = new AtomicReference<>();

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.f38496b = subscriber;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38497c, subscription)) {
                this.f38497c = subscription;
                this.f38496b.a(this);
                subscription.request(Clock.MAX_TIME);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(boolean z2, boolean z3, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.f38500f) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z2) {
                return false;
            } else {
                Throwable th = this.f38499e;
                if (th != null) {
                    atomicReference.lazySet((Object) null);
                    subscriber.onError(th);
                    return true;
                } else if (!z3) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void cancel() {
            if (!this.f38500f) {
                this.f38500f = true;
                this.f38497c.cancel();
                if (getAndIncrement() == 0) {
                    this.f38502h.lazySet((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z2;
            boolean z3;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f38496b;
                AtomicLong atomicLong = this.f38501g;
                AtomicReference<T> atomicReference = this.f38502h;
                int i2 = 1;
                do {
                    long j2 = 0;
                    while (true) {
                        z2 = false;
                        if (j2 == atomicLong.get()) {
                            break;
                        }
                        boolean z4 = this.f38498d;
                        T andSet = atomicReference.getAndSet((Object) null);
                        if (andSet == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!b(z4, z3, subscriber, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(andSet);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 == atomicLong.get()) {
                        boolean z5 = this.f38498d;
                        if (atomicReference.get() == null) {
                            z2 = true;
                        }
                        if (b(z5, z2, subscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.c(atomicLong, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void onComplete() {
            this.f38498d = true;
            d();
        }

        public void onError(Throwable th) {
            this.f38499e = th;
            this.f38498d = true;
            d();
        }

        public void onNext(T t2) {
            this.f38502h.lazySet(t2);
            d();
        }

        public void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this.f38501g, j2);
                d();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38421c.n(new BackpressureLatestSubscriber(subscriber));
    }
}
