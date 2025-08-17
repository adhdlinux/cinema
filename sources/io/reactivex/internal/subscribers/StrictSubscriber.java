package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    final Subscriber<? super T> f40045b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicThrowable f40046c = new AtomicThrowable();

    /* renamed from: d  reason: collision with root package name */
    final AtomicLong f40047d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<Subscription> f40048e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    final AtomicBoolean f40049f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f40050g;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f40045b = subscriber;
    }

    public void a(Subscription subscription) {
        if (this.f40049f.compareAndSet(false, true)) {
            this.f40045b.a(this);
            SubscriptionHelper.c(this.f40048e, this.f40047d, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void cancel() {
        if (!this.f40050g) {
            SubscriptionHelper.a(this.f40048e);
        }
    }

    public void onComplete() {
        this.f40050g = true;
        HalfSerializer.b(this.f40045b, this, this.f40046c);
    }

    public void onError(Throwable th) {
        this.f40050g = true;
        HalfSerializer.d(this.f40045b, th, this, this.f40046c);
    }

    public void onNext(T t2) {
        HalfSerializer.f(this.f40045b, t2, this, this.f40046c);
    }

    public void request(long j2) {
        if (j2 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
            return;
        }
        SubscriptionHelper.b(this.f40048e, this.f40047d, j2);
    }
}
