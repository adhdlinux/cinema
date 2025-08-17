package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Publisher<? extends T> f39088b;

    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39089b;

        /* renamed from: c  reason: collision with root package name */
        Subscription f39090c;

        PublisherSubscriber(Observer<? super T> observer) {
            this.f39089b = observer;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f39090c, subscription)) {
                this.f39090c = subscription;
                this.f39089b.onSubscribe(this);
                subscription.request(Clock.MAX_TIME);
            }
        }

        public void dispose() {
            this.f39090c.cancel();
            this.f39090c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f39090c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f39089b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39089b.onError(th);
        }

        public void onNext(T t2) {
            this.f39089b.onNext(t2);
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f39088b = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f39088b.a(new PublisherSubscriber(observer));
    }
}
