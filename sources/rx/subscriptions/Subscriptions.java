package rx.subscriptions;

import rx.Subscription;
import rx.functions.Action0;

public final class Subscriptions {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsubscribed f42177a = new Unsubscribed();

    private static final class Unsubscribed implements Subscription {
        private Unsubscribed() {
        }

        public void unsubscribe() {
        }
    }

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription a(Action0 action0) {
        return BooleanSubscription.a(action0);
    }
}
