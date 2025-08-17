package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38493b;

        /* renamed from: c  reason: collision with root package name */
        Subscription f38494c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38495d;

        BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.f38493b = subscriber;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38494c, subscription)) {
                this.f38494c = subscription;
                this.f38493b.a(this);
                subscription.request(Clock.MAX_TIME);
            }
        }

        public void cancel() {
            this.f38494c.cancel();
        }

        public void onComplete() {
            if (!this.f38495d) {
                this.f38495d = true;
                this.f38493b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38495d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38495d = true;
            this.f38493b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38495d) {
                if (get() != 0) {
                    this.f38493b.onNext(t2);
                    BackpressureHelper.c(this, 1);
                    return;
                }
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }
    }

    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38421c.n(new BackpressureErrorSubscriber(subscriber));
    }
}
