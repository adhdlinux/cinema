package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final Scheduler f38513d;

    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38514b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler f38515c;

        /* renamed from: d  reason: collision with root package name */
        Subscription f38516d;

        final class Cancellation implements Runnable {
            Cancellation() {
            }

            public void run() {
                UnsubscribeSubscriber.this.f38516d.cancel();
            }
        }

        UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.f38514b = subscriber;
            this.f38515c = scheduler;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38516d, subscription)) {
                this.f38516d = subscription;
                this.f38514b.a(this);
            }
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f38515c.c(new Cancellation());
            }
        }

        public void onComplete() {
            if (!get()) {
                this.f38514b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f38514b.onError(th);
            }
        }

        public void onNext(T t2) {
            if (!get()) {
                this.f38514b.onNext(t2);
            }
        }

        public void request(long j2) {
            this.f38516d.request(j2);
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f38513d = scheduler;
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38421c.n(new UnsubscribeSubscriber(subscriber, this.f38513d));
    }
}
