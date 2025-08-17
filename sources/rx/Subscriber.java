package rx;

import com.facebook.common.time.Clock;
import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private final SubscriptionList cs;
    private final Subscriber<?> op;

    /* renamed from: p  reason: collision with root package name */
    private Producer f42067p;
    private long requested;

    protected Subscriber() {
        this((Subscriber<?>) null, false);
    }

    public final void add(Subscription subscription) {
        this.cs.a(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.cs.isUnsubscribed();
    }

    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public final void request(long j2) {
        Producer producer;
        if (j2 >= 0) {
            synchronized (this) {
                producer = this.f42067p;
                if (producer == null) {
                    long j3 = this.requested;
                    if (j3 == Long.MIN_VALUE) {
                        this.requested = j2;
                    } else {
                        long j4 = j3 + j2;
                        if (j4 < 0) {
                            this.requested = Clock.MAX_TIME;
                        } else {
                            this.requested = j4;
                        }
                    }
                    producer = null;
                }
            }
            if (producer != null) {
                producer.request(j2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j2);
    }

    public void setProducer(Producer producer) {
        long j2;
        Subscriber<?> subscriber;
        boolean z2;
        synchronized (this) {
            j2 = this.requested;
            this.f42067p = producer;
            subscriber = this.op;
            if (subscriber == null || j2 != Long.MIN_VALUE) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            subscriber.setProducer(producer);
        } else if (j2 == Long.MIN_VALUE) {
            producer.request(Clock.MAX_TIME);
        } else {
            producer.request(j2);
        }
    }

    public final void unsubscribe() {
        this.cs.unsubscribe();
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    protected Subscriber(Subscriber<?> subscriber, boolean z2) {
        this.requested = Long.MIN_VALUE;
        this.op = subscriber;
        this.cs = (!z2 || subscriber == null) ? new SubscriptionList() : subscriber.cs;
    }
}
