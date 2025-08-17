package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: d  reason: collision with root package name */
    final Consumer<? super T> f38488d = this;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38489b;

        /* renamed from: c  reason: collision with root package name */
        final Consumer<? super T> f38490c;

        /* renamed from: d  reason: collision with root package name */
        Subscription f38491d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38492e;

        BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f38489b = subscriber;
            this.f38490c = consumer;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38491d, subscription)) {
                this.f38491d = subscription;
                this.f38489b.a(this);
                subscription.request(Clock.MAX_TIME);
            }
        }

        public void cancel() {
            this.f38491d.cancel();
        }

        public void onComplete() {
            if (!this.f38492e) {
                this.f38492e = true;
                this.f38489b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38492e) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38492e = true;
            this.f38489b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38492e) {
                if (get() != 0) {
                    this.f38489b.onNext(t2);
                    BackpressureHelper.c(this, 1);
                    return;
                }
                try {
                    this.f38490c.accept(t2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
    }

    public void accept(T t2) {
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38421c.n(new BackpressureDropSubscriber(subscriber, this.f38488d));
    }
}
