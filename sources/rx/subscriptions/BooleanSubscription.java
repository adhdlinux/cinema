package rx.subscriptions;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Subscription;
import rx.functions.Action0;

public final class BooleanSubscription implements Subscription {

    /* renamed from: d  reason: collision with root package name */
    static final AtomicIntegerFieldUpdater<BooleanSubscription> f42172d = AtomicIntegerFieldUpdater.newUpdater(BooleanSubscription.class, "c");

    /* renamed from: b  reason: collision with root package name */
    private final Action0 f42173b;

    /* renamed from: c  reason: collision with root package name */
    volatile int f42174c;

    public BooleanSubscription() {
        this.f42173b = null;
    }

    public static BooleanSubscription a(Action0 action0) {
        return new BooleanSubscription(action0);
    }

    public boolean isUnsubscribed() {
        return this.f42174c != 0;
    }

    public final void unsubscribe() {
        Action0 action0;
        if (f42172d.compareAndSet(this, 0, 1) && (action0 = this.f42173b) != null) {
            action0.call();
        }
    }

    private BooleanSubscription(Action0 action0) {
        this.f42173b = action0;
    }
}
