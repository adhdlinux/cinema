package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final Scheduler f38503d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f38504e;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38505b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler.Worker f38506c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<Subscription> f38507d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f38508e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final boolean f38509f;

        /* renamed from: g  reason: collision with root package name */
        Publisher<T> f38510g;

        static final class Request implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final Subscription f38511b;

            /* renamed from: c  reason: collision with root package name */
            final long f38512c;

            Request(Subscription subscription, long j2) {
                this.f38511b = subscription;
                this.f38512c = j2;
            }

            public void run() {
                this.f38511b.request(this.f38512c);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z2) {
            this.f38505b = subscriber;
            this.f38506c = worker;
            this.f38510g = publisher;
            this.f38509f = !z2;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.e(this.f38507d, subscription)) {
                long andSet = this.f38508e.getAndSet(0);
                if (andSet != 0) {
                    b(andSet, subscription);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2, Subscription subscription) {
            if (this.f38509f || Thread.currentThread() == get()) {
                subscription.request(j2);
            } else {
                this.f38506c.b(new Request(subscription, j2));
            }
        }

        public void cancel() {
            SubscriptionHelper.a(this.f38507d);
            this.f38506c.dispose();
        }

        public void onComplete() {
            this.f38505b.onComplete();
            this.f38506c.dispose();
        }

        public void onError(Throwable th) {
            this.f38505b.onError(th);
            this.f38506c.dispose();
        }

        public void onNext(T t2) {
            this.f38505b.onNext(t2);
        }

        public void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                Subscription subscription = this.f38507d.get();
                if (subscription != null) {
                    b(j2, subscription);
                    return;
                }
                BackpressureHelper.a(this.f38508e, j2);
                Subscription subscription2 = this.f38507d.get();
                if (subscription2 != null) {
                    long andSet = this.f38508e.getAndSet(0);
                    if (andSet != 0) {
                        b(andSet, subscription2);
                    }
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f38510g;
            this.f38510g = null;
            publisher.a(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z2) {
        super(flowable);
        this.f38503d = scheduler;
        this.f38504e = z2;
    }

    public void o(Subscriber<? super T> subscriber) {
        Scheduler.Worker a2 = this.f38503d.a();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, a2, this.f38421c, this.f38504e);
        subscriber.a(subscribeOnSubscriber);
        a2.b(subscribeOnSubscriber);
    }
}
